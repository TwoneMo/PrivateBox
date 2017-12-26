package priv.henryyu.privatebox.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;
/**
 * IndexController class
 * 
 * @author HenryYu
 * @date 2017/12/15
 * @version 1.0.0
 */
@Controller
public class IndexController {
	@Autowired
	HttpServletRequest request;
	@Autowired
	private MessageSource messageSource;
	@RequestMapping("/loginerror")
	public String loginError() {
		//Locale locale= RequestContextUtils.getLocale(request);
		//String LoginError=messageSource.getMessage("loginError", null,locale);
		request.getSession().setAttribute("loginError", "");
		return "redirect:/";
	}
	
	@RequestMapping("/")
	public String index() {
		//UserDetails userDetails=(UserDetails) request.getSession().getAttribute("userDetails");
		if(request.getSession().getAttribute("userDetails")!=null) {
			return "redirect:/user/index";
		}
		return "index";
	}
}
