package com.techigai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techigai.model.User;
import com.techigai.repo.UserRepo;
@Controller
public class UserRegistration {
	@Autowired
	private UserRepo repo;
		
	@RequestMapping(value="/registeruser",method=RequestMethod.POST)
	public String Add(@RequestParam("name") String name,@RequestParam("pwd") String pwd,@RequestParam("role") String role) {
		User usr = new User();
		usr.setUname(name);
		usr.setPassword(pwd);
		usr.setRole(role);
		repo.save(usr);
		return "userlogin";
	}
}
