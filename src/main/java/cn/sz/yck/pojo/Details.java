package cn.sz.yck.pojo;

import java.io.Serializable;
/**
 * ∂©µ•œÍ«È±Ì
 * @author Administrator
 *
 */

public class Details implements Serializable {
	
	private Integer order_number;
	private Integer booid;
	private String book_name;
	private Double book_price;
	private String img_path;
	private Integer book_count;
	public Integer getOrder_number() {
		return order_number;
	}
	public void setOrder_number(Integer order_number) {
		this.order_number = order_number;
	}
	public Integer getBooid() {
		return booid;
	}
	public void setBooid(Integer booid) {
		this.booid = booid;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public Double getBook_price() {
		return book_price;
	}
	public void setBook_price(Double book_price) {
		this.book_price = book_price;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public Integer getBook_count() {
		return book_count;
	}
	public void setBook_count(Integer book_count) {
		this.book_count = book_count;
	}
	

}
