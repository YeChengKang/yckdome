package cn.sz.yck.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.yck.dao.IBookDAOName;
import cn.sz.yck.pojo.Book;
import cn.sz.yck.service.IBookNameService;

@Service
public class BookNameServiceImpl implements IBookNameService {
	
	@Autowired
	private IBookDAOName bookname;

	
	public List<Book> findallByName() {
		return bookname.findallbookByName();
	}

}
