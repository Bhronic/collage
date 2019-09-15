package com.java.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.beans.Result;
import com.java.beans.Subject;
import com.java.beans.User;
import com.java.service.UserService;

@Controller
public class StudentViewController {
	@Autowired
	public UserService service;
	 
	
	 @RequestMapping(value = "/student_total_result", method = RequestMethod.GET)
	    public String viewResult(HttpServletRequest request,Model model) {
	        int id = Integer.parseInt(request.getParameter("id"));
	        User user = service.getUserById(id);
	        String  faculty_name=user.getFaculty_name();
	        String branch=user.getBranch();
	        String specialisation=user.getSpecialisation();
	        String semester=user.getSemester();
	        String course=user.getCourse();
	        int sem1=Integer.parseInt(semester);
	        int student_id=id;
	        
	        if (sem1<=2) {
     		branch="null";
     		specialisation="null";
     		List<Subject> subject=service.subjectByCourse_Branch(course, semester, branch, specialisation);
     		int e_mark=0; 
             int i_mark=0;	        
     		for(Subject sub:subject) {
     			String external_marks=sub.getExternal_marks();
     			int ex_mark=Integer.parseInt(external_marks);
     			String internal_marks=sub.getInternal_marks();
     			int in_mark=Integer.parseInt(internal_marks);
     			e_mark=e_mark+ex_mark;
     			i_mark=i_mark+in_mark;
     			
     		}
     		int maximum_mark=e_mark+i_mark;
     		System.out.println(maximum_mark);
     //		model.addAttribute("maximum_mark",maximum_mark);
     	//	model.addAttribute("student_id",student_id);
 //	        model.addAttribute("semester",semester);
 	     // model.addAttribute("subject",subject);
 	       
 	        List< Result> result=service.getResultById(student_id); 
 	        int e_mark_ob=0;
 	        int i_mark_ob=0;
 	        for (Result res:result) {
 	        	String external_marks_ob=res.getExternal_marks_ob();
 	        	int e_m_o=Integer.parseInt(external_marks_ob);
 	        	String internal_marks_ob=res.getInternal_marks_ob();
 	        	int i_m_o=Integer.parseInt(internal_marks_ob);
 	        	e_mark_ob=e_mark_ob+e_m_o;
 	        	i_mark_ob=i_mark_ob+i_m_o;
 	        }
 	        int mark_obtain=e_mark_ob+i_mark_ob;
 	        System.out.println(mark_obtain); 
 	       double percentage =(double)mark_obtain / maximum_mark;
	        double per=percentage*100;
	        double s = Math.round(per * 100.0) / 100.0;
		      
	        System.out.println(percentage);
	        System.out.println(per);
	        System.out.println(s);
 	        model.addAttribute("maximum_mark",maximum_mark);
     		model.addAttribute("student_id",student_id);
     		model.addAttribute("id",id);
 	        model.addAttribute("semester",semester);
 	        model.addAttribute("e_mark_ob",e_mark_ob);
 			model.addAttribute("i_mark_ob",i_mark_ob);
 			model.addAttribute("mark_obtain",mark_obtain);  
 			model.addAttribute("per",s);
 			model.addAttribute("result",result);  
     	}
		  
	 
	        return "student_result_total";
	 }
	
	
	
	
	
	
	
	
	@RequestMapping(value="/student_view_result", method=RequestMethod.GET)
	public String resultViewStudent(HttpServletRequest request,Model model) {
	 	int id = Integer.parseInt(request.getParameter("id"));
        User user = service.getUserById(id);  
        String faculty_name=user.getFaculty_name();
        int student_id=id;
        List< Result> result=service.getResultById(student_id); 
       // String msg="Marks Obtained by Student";
       // model.addAttribute("msg", msg);
	    model.addAttribute("user", user);
	    model.addAttribute("result", result);
	    
	    return "student_result_view";
	}

	
	
	
	
	
	
	
	
	
	
}
