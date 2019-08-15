package cn.sz.yck.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sz.yck.pojo.Account;
import cn.sz.yck.pojo.Book;
import cn.sz.yck.pojo.Order;
import cn.sz.yck.pojo.Users;
import cn.sz.yck.service.IAccountService;
import cn.sz.yck.service.IBookService;
import cn.sz.yck.service.IOrderService;
import cn.sz.yck.service.IUserService;
import cn.sz.yck.util.BalanceLessException;
import cn.sz.yck.util.StoreHouseLessException;

@Controller
@RequestMapping("/uc")
public class UserController {

	@Autowired
	private IUserService userServiceImpl;
	
	@Autowired
	private IAccountService accService;
	
	@Autowired
	private IBookService  bookService;
	
	@Autowired
	private IOrderService orderService;
	
	@RequestMapping(value="login")
	public String islogin(Users u,HttpServletRequest request){
		Users users = userServiceImpl.islogin(u);
		if(users!=null){
			request.getSession().setAttribute("myusers", users);
			return "redirect:/bc/findall";
		}
		return "login";
	}
	
	@RequestMapping(value="findAccount")
	public String findAccountByUser(HttpServletRequest request,Model model,Integer bookid) {
		//得到当前用户
		Users u = (Users) request.getSession().getAttribute("myusers");
		Integer id = (Integer) request.getSession().getAttribute("bookid");
		Integer price = (Integer) request.getSession().getAttribute("bookPrice");
		Order o = new Order();
		o.setOrder_number(1001);
		o.setRealname(u.getRealname());
		o.setPhone(u.getPhone());
		o.setBookid(id);
		o.setMoney(price);
		o.setAddress("xxx-xxx-xxx-xx-xx");
		o.setStatus(1);
		orderService.inserall(o);
		//根据当前用户查询所对应的账户
		List<Account> acclist = accService.findAccByUserid(u.getUserid());
		model.addAttribute("acclist", acclist);
		Book book = bookService.findallByName(bookid);
		model.addAttribute("book", book);
		return "book_prebuy";
	}
	
	@RequestMapping(value="findbalance",method=RequestMethod.POST)
	public void findBalanceByAccid(Integer accid,HttpServletResponse response) throws IOException {
		Double balance = accService.findBalanceByAccid(accid);
		PrintWriter out = response.getWriter();
		out.print(balance);
		out.flush();
		out.close();
	}
	
	@RequestMapping(value="buybook",method=RequestMethod.POST)
	public String buybook(Integer bookid,Integer accid){
		System.out.println("buybook...");
		try {
			boolean flag = userServiceImpl.buybook(bookid,accid);
		} catch (StoreHouseLessException e) {
			e.printStackTrace();
		} catch (BalanceLessException e) {
			e.printStackTrace();
		}
		return "redirect:/bc/findall";
	}
}
