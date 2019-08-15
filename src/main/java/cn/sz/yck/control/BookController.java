package cn.sz.yck.control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.sz.yck.pojo.Book;
import cn.sz.yck.pojo.StoreHouse;
import cn.sz.yck.service.IBookService;
import cn.sz.yck.service.IStoreHouseService;

@Controller
@RequestMapping("bc")
public class BookController {

	@Autowired
	private IBookService bookService;
	
	@Autowired
	private IStoreHouseService houseService;
	
//	@Autowired
//	private ServletContext context;
	
	@RequestMapping(value="findall",method=RequestMethod.GET)
	public String showallbook(Model model){
		
		List<Book>  booklist = bookService.findall();
		model.addAttribute("booklist", booklist);
		return "book_list";
	}
	
	@RequestMapping(value="index",method=RequestMethod.GET)
	public String showname(Integer bookid,Model model) {
		Book b = bookService.findallByName(bookid);
		System.out.println(b.getImgPath());
		model.addAttribute("bookname", b);
		return "index";
	}
	
	//@RequestMapping(value="reg",method=RequestMethod.POST)
	public String islogin(Book b,Model model) {
		boolean flag = bookService.insertall(b);
		List<Book>  booklist = bookService.findall();
		model.addAttribute("booklist", booklist);
		if(flag) {
			return "book_list";
		}
		return "reg";
	}
	
	@RequestMapping(value="reg",method=RequestMethod.POST)
	public String addbook(Book b,@RequestParam MultipartFile pic,HttpServletRequest request,Integer bookid) {
		System.out.println("islogin...");
		System.out.println("接收到的日期："+b.getPublicDate());
		System.out.println("接收book信息："+b.getBookName());
		System.out.println("文件："+pic.getOriginalFilename());
		System.out.println(bookid);
		
		houseService.findStoreHouseByBookid(bookid);
		
		try {
			InputStream is = pic.getInputStream();
			//获取bookimg文件夹的绝对路径
			String realpath = request.getSession().getServletContext().getRealPath("/bookimg");
//			ServletContext
			System.out.println(realpath);
			
			String newfilename = UUID.randomUUID().toString();
			String endname = pic.getOriginalFilename().substring(pic.getOriginalFilename().lastIndexOf("."));
			OutputStream os = new FileOutputStream(new File(realpath+"/"+newfilename+endname));

			FileCopyUtils.copy(is, os);
			b.setImgPath("bookimg/"+newfilename+endname);
//			String picName= pic.getOriginalFilename();
//			String picDir= context.getRealPath("/images");
//			InputStream input= pic.getInputStream();
//			Files.copy(input,Paths.get(picDir,picName));
			System.out.print(b.getImgPath());
			//book对象保存到数据库
			bookService.insertall(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/bc/findall";
	}
	
	@RequestMapping(value="num")
	public String showbookByName() {
		
		return "reg";
	}
	
	
	
}
