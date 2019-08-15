package cn.sz.yck.service;

import java.util.List;

import cn.sz.yck.pojo.Account;

public interface IAccountService {
	
	public List<Account> findAccByUserid(Integer userid);
	
	public Double findBalanceByAccid(Integer accid);

}
