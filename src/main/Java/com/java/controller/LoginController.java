package com.java.controller;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.java.beans.User;
import com.java.service.UserService;

@Controller
public class LoginController {
	@Autowired
	public UserService service;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
public String login(@ModelAttribute("User") User u, Model m) {
		
		String email = u.getEmail();
		String password = u.getPassword();
		List<User> user = service.checkLogin(email, password);
		m.addAttribute("user", user);
		String  z = null;
		
		for (User x : user) {
			z=x.getRole_type();
		}
		
		if(z.equals("Admin")) {
			return "admin";
		}
		else if (z.equals("Faculty")) {
			return "faculty";
		}
		else if (z.equals("Student")){
			return "student";
		}
		
		else {
			return "error";
		}
	}
	@RequestMapping(value = "/userinfo", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getLogin(@ModelAttribute("User") User u,Model model) {
		String email = u.getEmail();
		String password = u.getPassword();
		List<User> user = service.checkLogin(email, password);
	//	model.addAttribute("user", new User());
		model.addAttribute("user", user);
		return "userinfo";
	}

/*@RequestMapping(value="/user", method=RequestMethod.GET)
public @ResponseBody Map<String,Object> userList(HttpServletRequest req,HttpServletResponse res) {
	Map<String,Object> map=new HashMap<String,Object>();
	try {
	
	List<User> user=service.listUsers();
	map.put("data", user);
    map.put("status", "True");
	}
	catch(Exception e) {System.out.println(e);
	map.put("status", "False");
	}
	
	
	
	
	return map;
	
	
}*/
/*@RequestMapping(value="/user",method=RequestMethod.GET)
public @ResponseBody
Map<String,Object> getDetails(HttpServletRequest request){
	Map<String,Object> modelMap = new HashMap<String,Object>();
	List<User> list=service.listUsers();
	modelMap.put("data", list);
	//JSONObject obj=new JSONObject();
	//obj.put("data", list.get(1));
	//System.out.println(obj);
	return modelMap;
}*/


	
	/* @RequestMapping(value="/user")
	    public String listOfTeams() {
	      //  ModelAndView modelAndView = new ModelAndView("list-of-user");
	 
	        List
	 
	          user = service.listUsers();
	        modelAndView.addObject("teams", user);
	 
	        return modelAndView;
	    }
	
	
}

*/

/*@RequestMapping(value = "user", method = RequestMethod.GET, headers = "Accept=application/json")
public String getUser(Model model) {

	List listUsers = service.listUsers();
	model.addAttribute("user", new User());
	model.addAttribute("listUsers", listUsers);
	return "userlist";
}

/*	 public ModelAndView listUsers(ModelAndView model) throws IOException {
	        List<User> listUsers = service.listUsers();
	        model.addObject("listUsers", listUsers);
	        model.setViewName("userlist");
	        return model;
	    }
*/
}