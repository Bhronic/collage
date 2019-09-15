package com.java.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.beans.Branch;
import com.java.beans.Course;
import com.java.beans.User;    
import com.java.dao.UserDao;
import com.java.service.UserService;    
@Controller    
public class RegistrationController {    
    @Autowired    
    UserService service;//will inject dao from XML file    
        
    @RequestMapping("/registration")    
    public String showform(Model m){    
        m.addAttribute("command", new User());  
        return "registration";   
    }    
    
    @RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("user") User user){
    	int id=user.getId();
    	System.out.println("Id"+id);
        service.saveUser(user);    
        return "successRegister";  
    } 
   /* @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("user") User user) {
        if (user.getId() == 0) { // if employee id is 0 then creating the
            // employee other updating the employee
            service.saveUser(user);
        } else {
            service.updateUser(user);
        }
        return ("redirect:/login");
    } */
 
    @ModelAttribute("course")
    public List<Course> listCours(HttpServletRequest request,HttpServletResponse response) {

    	List<Course> course = service.course();
    	return course;
    }
  
    @ModelAttribute("faculty")
    public List<User> listFaculty(HttpServletRequest request,HttpServletResponse response) {

    	List<User> user = service.faculty();
    	
    	
    	return user;
    }
    @ModelAttribute("branch")
    public List<Branch> listBranch(HttpServletRequest request,HttpServletResponse response) {

    	List<Branch> branch = service.branch();
    	return branch;
    }

}