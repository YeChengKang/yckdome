package cn.sz.yck.service;

import java.util.List;

import cn.sz.yck.pojo.Book;

public interface IBookNameService {
	
	public List<Book> findallByName();

}
