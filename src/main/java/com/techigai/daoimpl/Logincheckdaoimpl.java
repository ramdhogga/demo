package com.techigai.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.techigai.model.User;
import com.techigai.repo.UserRepo;

@Component
public class Logincheckdaoimpl {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Autowired
	private UserRepo repo;
	public User checkUser(String name,String pwd) {
	 try {
    	  User usr = repo.findUserRole(name,pwd);
		return usr;
	   }catch(Exception e) {
		   User obj=new User();
		return obj;
	   }
}
}
