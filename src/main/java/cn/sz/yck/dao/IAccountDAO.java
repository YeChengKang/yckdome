package cn.sz.yck.dao;

import java.util.List;
import java.util.Map;

import cn.sz.yck.pojo.Account;

public interface IAccountDAO {
	
	public List<Account> findAccByUserid(Integer userid);
	
	/**
	 * �����˻���ţ���ѯ�˻����
	 * @param accid
	 * @return
	 */
	public Double findBalanceByAccid(Integer accid);
	
	/**
	 * �˻�������
	 * @param map
	 */
	public void changeBalance(Map<String, Object> map);

}
