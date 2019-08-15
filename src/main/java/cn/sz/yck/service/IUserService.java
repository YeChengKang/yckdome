package cn.sz.yck.service;

import cn.sz.yck.pojo.Users;
import cn.sz.yck.util.BalanceLessException;
import cn.sz.yck.util.StoreHouseLessException;

public interface IUserService {
	
	public Users islogin(Users u);
	
	/**
	 *  µœ÷¬Ú È
	 * @return
	 */
	public boolean buybook(Integer bookid,Integer accid)throws StoreHouseLessException, BalanceLessException ;

}
