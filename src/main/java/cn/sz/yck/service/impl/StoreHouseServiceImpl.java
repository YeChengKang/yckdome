package cn.sz.yck.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.yck.dao.IStoreHouseDAO;
import cn.sz.yck.service.IStoreHouseService;

@Service
public class StoreHouseServiceImpl implements IStoreHouseService {
	
	@Autowired
	private IStoreHouseDAO houstdao;

	public boolean findStoreHouseByBookid(Integer bookid) {
		return houstdao.findStoreHouseByBookid(bookid);
	}

}
