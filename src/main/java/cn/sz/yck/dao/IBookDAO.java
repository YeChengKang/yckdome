package cn.sz.yck.dao;

import java.util.List;

import cn.sz.yck.pojo.Book;

public interface IBookDAO {
	
	public List<Book> findallbook();
	
	public Book findallbookByName(Integer bookid);
	
	public boolean insertallbook(Book b);
	
	/**
	 * 根据书籍编号查询书籍价格
	 * @param bookid
	 * @return
	 */
	public Double findPriceByBookid(Integer bookid);

}
