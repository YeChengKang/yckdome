package cn.sz.yck.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.sz.yck.dao.IAccountDAO;
import cn.sz.yck.dao.IBookDAO;
import cn.sz.yck.dao.IUserDAO;
import cn.sz.yck.pojo.Users;
import cn.sz.yck.service.IUserService;
import cn.sz.yck.util.BalanceLessException;
import cn.sz.yck.util.StoreHouseLessException;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDAO userDAOImpl;
	@Autowired
	private IAccountDAO accdao;
	@Autowired
	private IBookDAO bookdao;
	
	public Users islogin(Users u) {
		return userDAOImpl.findUserByNameAndPwd(u);
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,rollbackFor={StoreHouseLessException.class,BalanceLessException.class},readOnly=false,timeout=20)
	public boolean buybook(Integer bookid,Integer accid) throws StoreHouseLessException, BalanceLessException {
		//1.�������Ҫ��һ
		//��Ҫ�ѿ�������õ�
		Integer count = userDAOImpl.findCountByBookid(bookid);
		System.out.println(count);
		if(count<=0) {
			throw new StoreHouseLessException("�����������");
		}
		userDAOImpl.countplusone(bookid);
		//2.�˻����Ҫ����
		Map<String, Object> map = new HashMap<String, Object>();
		//�õ��˻����е����
		Double balance = accdao.findBalanceByAccid(accid);
		//�����鼮��Ų�ѯ�鼮�۸�
		Double price = bookdao.findPriceByBookid(bookid);
		if(balance - price<0) {
			throw new BalanceLessException("�˻�����");
		}
		Double newmoney = balance - price;
		map.put("newmoney", newmoney);
		map.put("accid", accid);
		accdao.changeBalance(map);
		return true;
	}

}
