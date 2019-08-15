package cn.sz.yck.control;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/dc")
public class BookByNameController {
	
	
	@RequestMapping(value="index")
	public String showbookByName() {
		
		return "reg";
	}

}
