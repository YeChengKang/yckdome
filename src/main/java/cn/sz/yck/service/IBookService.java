package cn.sz.yck.service;

import java.util.List;

import cn.sz.yck.pojo.Book;

public interface IBookService {

	public List<Book> findall();
	
	public Book findallByName(Integer bookid);
	
	public boolean insertall(Book b);
	
}
