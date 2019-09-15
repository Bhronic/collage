package com.java.controller;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.log4j.Logger;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.beans.*;
import com.java.dao.UserDao;
import com.java.service.*;

@Controller
//@RequestMapping("/user")
public class ForgotPasswordController {
	@Autowired
	public UserService service;
	 @RequestMapping("/forgot")    
	    public String showform(Model m){    
	       // m.addAttribute("command", new User());  
	        return "forgot";   
	    }
	@RequestMapping(value = "/forgot_password", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("User") User u, Model m) {
		String msg = "";
		String email = u.getEmail();
		String security_question=u.getSecurity_question();
		String security_answer = u.getSecurity_answer();
	//	System.out.println(security_question);
		boolean isValid =service.checkUser(email, security_question,security_answer);
		//.info("Is user valid?= " + isValid);
		 
        if(isValid) {
        	
        	
        	return new ModelAndView("forgot_reset","email",email);
        
        }
        	else {
            msg = "Invalid credentials";
        }
 
        return new ModelAndView("result", "output", msg);
    }

	@RequestMapping(value = "/reset_password", method = RequestMethod.POST)
	public ModelAndView resetpassword(@ModelAttribute("User") User u, Model m) {
		String msg = "";
		
		String email = u.getEmail();
		System.out.println("you are in forgot controller" +email);
		String password=u.getPassword();
		 int up= service.updatePassword(email, password);	
	     if(up>0) {
		 return new ModelAndView("successRegister");
		
		//.info("Is user valid?= " + isValid);
	
	}
	     else {
	            msg = "Invalid credentials";
	        }
	 
	        return new ModelAndView("result", "output", msg);
	}
	
	
	
	
	
}

