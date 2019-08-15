package cn.sz.yck.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sz.yck.dao.IBookDAO;
import cn.sz.yck.pojo.Book;
import cn.sz.yck.service.IBookService;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookDAO bookdao;
	
	public List<Book> findall() {
		return bookdao.findallbook();
	}


	public Book findallByName(Integer bookid) {
		return bookdao.findallbookByName(bookid);
	}


	public boolean insertall(Book b) {
		return bookdao.insertallbook(b);
	}


}
