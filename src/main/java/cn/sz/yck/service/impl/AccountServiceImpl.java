package cn.sz.yck.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.yck.dao.IAccountDAO;
import cn.sz.yck.pojo.Account;
import cn.sz.yck.service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private IAccountDAO accdao;
	
	public List<Account> findAccByUserid(Integer userid) {
		return accdao.findAccByUserid(userid);
	}

	public Double findBalanceByAccid(Integer accid) {
		return accdao.findBalanceByAccid(accid);
	}

}
