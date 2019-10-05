package com.java.controller;
import java.io.IOException;
//import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;

import com.java.beans.Branch;
import com.java.beans.Course;
import com.java.beans.Image;
import com.java.beans.Subject;
import com.java.beans.User;
import com.java.service.UserService;

@Controller
public class AdminViewController {
	@Autowired
	public UserService service;
	
	
	
	 @ModelAttribute("course")
	    public List<Course> listCourse(HttpServletRequest request,HttpServletResponse response) {

	    	List<Course> course = service.course();
	    	return course;
	    }
	  
	    @ModelAttribute("faculty")
	    public List<User> listFaculty(HttpServletRequest request,HttpServletResponse response) {

	    	List<User> user = service.faculty();
	    	
	    	
	    	return user;
	    }
	    @ModelAttribute("branch")
	    public List<Branch> listBranchs(HttpServletRequest request,HttpServletResponse response) {

	    	List<Branch> branch = service.branch();
	    	return branch;
	    }
	 
	 /*   @RequestMapping(value = "/introduction", method = RequestMethod.GET)
	    public String marksheet(HttpServletRequest request,Model model) {
	        int id = Integer.parseInt(request.getParameter("id"));
	 	
	        User user = service.getUserById(id);
	        model.addAttribute("user", user);
	        return "admin_introduction";
	    }
	   */ 
	    
	    
	
@RequestMapping(value = "/faculty_view", method = RequestMethod.GET, headers = "Accept=application/json")
public String getFaculty(Model model) {

	List<User> facultyview = service.faculty();
	model.addAttribute("user", new User());
	model.addAttribute("facultyview", facultyview);
	return "faculty_view";
}
@RequestMapping(value = "/allstudent_view", method = RequestMethod.GET, headers = "Accept=application/json")
public String getStudent(Model model) {

	List<User> student = service.student();
	model.addAttribute("user", new User());
	model.addAttribute("student", student);
	return "allstudent_view";
}
@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
public String editUserPage(@PathVariable Integer id, Model model) {
   
    User user = service.getUserById(id);
    model.addAttribute("user", user);
    return "edit_userinfo";
}

 @RequestMapping(value="/update", method=RequestMethod.POST)
public String edditingUser(@ModelAttribute("user") User u, Model model) {

    String role=u.getRole_type();
    System.out.println(role);
    service.updateUser(u);

    String message = "Team was successfully edited.";
   if("Faculty".equals(role)) {
    return "redirect:/faculty_view";
} 
   else if("Student".equals(role)) {
	   return "redirect:/allstudent_view";
   }
   else {
	   return "redirect:/admin";
   }
 }
@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
public String deleteUser(@PathVariable Integer id, Model model) {
    service.removeUser(id);
    
    
    String message = "User successfully deleted.";
    
    return ("redirect:/faculty_view");
    
}

//course
@RequestMapping("/add_course")    
public String showform(Model m){    
    m.addAttribute("command", new Course());  
    return "add_course";   
}    
@RequestMapping(value="/saveCourse",method = RequestMethod.POST)    
public String save(@ModelAttribute("course") Course course){
	
	service.saveCourse(course);    
	return "redirect:/course";
} 
@RequestMapping(value = "/course", method = RequestMethod.GET, headers = "Accept=application/json")
public String viewAllCourse(Model model) {

	List<Course> course = service.course();
	
	model.addAttribute("course", course);
	return "course";
}

@ModelAttribute("allcourse")
public List<Course> listCours(HttpServletRequest request,HttpServletResponse response) {

	List<Course> course = service.course();
	
	
	return course;
}
@RequestMapping(value="/editCourse/{id}", method=RequestMethod.GET)
public String editCourse(@PathVariable Integer id, Model model) {
   
    Course course = service.getCourseById(id);
    model.addAttribute("course", course);
    return "edit_course";
}

 @RequestMapping(value="/updateCourse", method=RequestMethod.POST)
public String edditingCourse(@ModelAttribute("course") Course c, Model model) {

    
    service.updateCourse(c);

  
	   return "redirect:/course";
   }
 
@RequestMapping(value="/deleteCourse/{id}", method=RequestMethod.GET)
public String deleteCourse(@PathVariable Integer id, Model model) {
    service.deleteCourse(id);
    return ("redirect:/course");
    
}

//branch
@RequestMapping("/add_branch")    
public String showformBranch(Model m){    
    m.addAttribute("command", new Branch());  
    return "add_branch";   
}    
@RequestMapping(value="/saveBranch",method = RequestMethod.POST)    
public String save(@ModelAttribute("branch") Branch branch){
	
	service.saveBranch(branch);    
	return "redirect:/branch";
} 
@RequestMapping(value = "/branch", method = RequestMethod.GET, headers = "Accept=application/json")
public String viewAllBranch(Model model) {

	List<Branch> branch = service.branch();
	
	model.addAttribute("branch", branch);
	return "branch";
}

@ModelAttribute("allbranch")
public List<Branch> listBranch(HttpServletRequest request,HttpServletResponse response) {

	List<Branch> branch = service.branch();
	return branch;
}
@RequestMapping(value="/editBranch/{id}", method=RequestMethod.GET)
public String editBranch(@PathVariable Integer id, Model model) {
   
	Branch branch = service.getBranchById(id);
    model.addAttribute("branch", branch);
    return "edit_branch";
}

 @RequestMapping(value="/updateBranch", method=RequestMethod.POST)
public String edditingBranch(@ModelAttribute("branch") Branch c, Model model) {

    
    service.updateBranch(c);

  
	   return "redirect:/branch";
   }
 
@RequestMapping(value="/deleteBranch/{id}", method=RequestMethod.GET)
public String deleteBranch(@PathVariable Integer id, Model model) {
    service.deleteBranch(id);
    return ("redirect:/branch");
    
}

//subject
@RequestMapping("/add_subject")    
public String showformSubject(Model m){    
    m.addAttribute("command", new Subject());  
    return "add_subject";   
}    
@RequestMapping(value="/saveSubject",method = RequestMethod.POST)    
public String saveSubject(@ModelAttribute("subject") Subject subject){
	
	service.saveSubject(subject);    
	return "redirect:/subject";
} 
@RequestMapping(value = "/subject", method = RequestMethod.GET, headers = "Accept=application/json")
public String viewAllSubject(Model model) {

	List<Subject> subject = service.subject();
	
	model.addAttribute("subject", subject);
	return "subject";
}

@ModelAttribute("allSubject")
public List<Subject> listSubject(HttpServletRequest request,HttpServletResponse response) {

	List<Subject> subject = service.subject();
	return subject;
}
@RequestMapping(value="/editSubject/{id}", method=RequestMethod.GET)
public String editSubject(@PathVariable Integer id, Model model) {
   
	Subject subject = service.getSubjectById(id);
    model.addAttribute("subject", subject);
    return "edit_subject";
}

 @RequestMapping(value="/updateSubject", method=RequestMethod.POST)
public String edditingSubject(@ModelAttribute("subject") Subject sub, Model model) {

    
    service.updateSubject(sub);

  
	   return "redirect:/subject";
   }
 
@RequestMapping(value="/deleteSubject/{id}", method=RequestMethod.GET)
public String deleteSubject(@PathVariable Integer id, Model model) {
    service.deleteSubject(id);
    return ("redirect:/subject");
    
}


//operation on image
@RequestMapping("/add_image")    
public String showImageAdd(Model m){    
    m.addAttribute("command", new Image());  
    return "add_image";   
}
@RequestMapping(value = "/doUpload", method = RequestMethod.POST)
public String handleFileUpload(HttpServletRequest request,
        @RequestParam MultipartFile[] image) throws Exception {
      
    if (image != null && image.length > 0) {
        for (MultipartFile aFile : image){
              
            System.out.println("Saving file: " + aFile.getOriginalFilename());
             
            Image uploadFile = new Image();
            uploadFile.setImage_name(aFile.getOriginalFilename());
            uploadFile.setImage(aFile.getBytes());
            service.saveImage(uploadFile);               
        }
    }
  
    return "Faculty_Marksheet";
}  


@RequestMapping(value="/showimage/{id}",method=RequestMethod.GET)
public ModelAndView showImage(@PathVariable int id) throws IOException {
	Image img = service.getImageById(id);
	byte[] encoded=Base64.encodeBase64(img.getImage());
	//System.out.println("encoded byte = "+encoded);
	String encodedString = new String(encoded);
	//System.out.println("encoded string = "+encodedString);
	ModelAndView model = new ModelAndView();
	model.setViewName("Faculty_Marksheet");
	model.addObject("img", img);
	model.getModelMap().put("image", encodedString);
	return model;
}



}