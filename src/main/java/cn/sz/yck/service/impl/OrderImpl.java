package cn.sz.yck.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.yck.dao.IOrderDAO;
import cn.sz.yck.pojo.Order;
import cn.sz.yck.service.IOrderService;

@Service
public class OrderImpl implements IOrderService {
	
	@Autowired
	private IOrderDAO orderdao;

	public boolean inserall(Order o) {
		return orderdao.inserall(o);
	}

}
