package spring_mvc.login.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring_mvc.login.daoImpl.UserDaoImpl;
import spring_mvc.login.model.User;

@Controller
public class UserController {

	@Autowired
	private UserDaoImpl daoImpl;
	
	@RequestMapping("createUser")
	public ModelAndView createUser() {
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("user", new User());
		mv.setViewName("createuser.jsp");
		
		return mv;
	}
	
	@RequestMapping("saveUser")
	public ModelAndView saveUser(@ModelAttribute User user) {
		String message = daoImpl.saveUser(user);
		ModelAndView mv=new ModelAndView();
		mv.addObject("result", message);
		mv.setViewName("message.jsp");
		
		return mv;
	}
	
	@RequestMapping("displayUsers")
	public ModelAndView getAllUsers() {
		
		ArrayList<User> users = daoImpl.getAllUsers();
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("allusers", users);
		mv.setViewName("displayusers.jsp");
		
		return mv;
	}
}
