package com.techigai;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.auth0.AuthenticationController;
import com.techigai.daoimpl.Logincheckdaoimpl;
import com.techigai.model.User;
import com.techigai.service.ItemService;

@Controller
public class LoginPage {
	@Autowired
	private Logincheckdaoimpl dao;
	@Autowired
	private ItemService service;
	
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AuthenticationController controller;

	@RequestMapping(value="/loginpage",method=RequestMethod.GET)
	public String enterLogin(final HttpServletRequest req) {
		//return "userlogin";
		logger.debug("Performing login");
        String redirectUri = req.getScheme() + "://" + req.getServerName();
        if ((req.getScheme().equals("http") && req.getServerPort() != 80) || (req.getScheme().equals("https") && req.getServerPort() != 443)) {
            redirectUri += ":" + req.getServerPort();
        }
        redirectUri += "/callback";
        String authorizeUrl = controller.buildAuthorizeUrl(req, redirectUri)
                .withScope("openid profile email")
                .build();
        return "redirect:" + authorizeUrl;
	}
	
	@RequestMapping(value="/item",method=RequestMethod.GET)
	public String getitempage() {
		return "item";
	}
	@RequestMapping(value="/orderpage",method=RequestMethod.GET)
	public ModelAndView getorderpage() {
		return service.getAllItems();
	}
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String getregpage() {
		return "registerUser";
	}
	@RequestMapping(value="/logincheck",method=RequestMethod.POST)
	public ModelAndView checkuser(@RequestParam("name") String name,@RequestParam("pwd") String pwd,HttpServletRequest request) {	
		HttpSession session = request.getSession();
		User usr=dao.checkUser(name, pwd);
		session.setAttribute("user", usr);
		String role=usr.getRole();
		ModelAndView obj=new ModelAndView();
		if(role.equals("admin")) {
			 obj.setViewName("Adminpage");
		return obj;
	    }else if(role.equals("user")) {
	    return service.getItem();
	    }else {
	    	obj.setViewName("ErrorPage");
		return obj;
	    }
	
	
}
}