package com.java.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.beans.Image;
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

	
	
	
	 @RequestMapping(value = "/student_marksheet", method = RequestMethod.GET)
	    public ModelAndView marksheet(HttpServletRequest request) {
	        int id = Integer.parseInt(request.getParameter("id"));
	 	
	        User user = service.getUserById(id);
	        String  faculty_name=user.getFaculty_name();
	        String name=user.getName();
	        String branch=user.getBranch();
	        String specialisation=user.getSpecialisation();
	        String semester=user.getSemester();
	        String course=user.getCourse();
	        int sem1=Integer.parseInt(semester);
	        int student_id=id;
	        String br=branch;
	        if (sem1<=2) {
     		branch="null";
     		specialisation="null";
     		List<Subject> subject=service.subjectByCourse_Branch(course, semester, branch, specialisation);
     		int each_sub_total=0;
     		int total=0;
     		int session_total=0;
     		int exam_total=0;
     		int count=subject.size();
     		for(Subject sub:subject) {
     	    	int session=Integer.parseInt(sub.getInternal_marks());
     	    	int external=Integer.parseInt(sub.getExternal_marks());
     	    	each_sub_total=session+external;
     	    //total=total+each_sub_total;
     	   session_total=session_total+session;
     		exam_total=exam_total+external;
     		}
     		total=session_total+exam_total;
     	  System.out.println("Sessional total"+session_total);
     	  System.out.println("Exam total"+exam_total);     
 	      
     	  List< Result> result=service.getResultById(student_id);
     	  int session_mark=0;
     	  int exam_mark=0;
     	  int total_mark=0;
     	  int cre_total=0;
 	     for(Result res:result) {
 	    	 int session=Integer.parseInt(res.getInternal_marks_ob());
 	    	 int external=Integer.parseInt(res.getExternal_marks_ob());
 	    	 int cre=res.getCredit();
 	    	 session_mark=session_mark+session;
 	    	 exam_mark=exam_mark+external;
 	    	 cre_total=cre_total+cre;
 	     }
 	        total_mark=session_mark+exam_mark;
 	        int image_id=1;    
 		    Image img = service.getImageById(image_id);
 		 	byte[] encoded=Base64.encodeBase64(img.getImage());
 		 	String encodedString = new String(encoded);
 		 	
 		 	ModelAndView model = new ModelAndView();
 		 	model.setViewName("Faculty_Marksheet");
 		 	model.addObject("img", img);
 		 	model.getModelMap().put("image", encodedString);
 		 	
 		 	model.getModelMap().put("subject",subject);
 		 	model.getModelMap().put("result",result);
     		model.addObject("student_id",student_id);
 	        model.addObject("semester",semester);
 	        model.addObject("name",name);
 	        model.addObject("course",course);
 	        model.addObject("branch",br);
 	        model.getModelMap().put("each_sub_total",each_sub_total);
 	        model.addObject("total",total);
 	        model.addObject("session_total",session_total);
 	        model.addObject("exam_total",exam_total);
 	        model.addObject("session_mark",session_mark);
 	        model.addObject("exam_mark",exam_mark);
 	        model.addObject("total_mark",total_mark);
 	        model.addObject("cre_total",cre_total);
//  	        model.addObject("subject",subect);
 	   //     model.addObject("e_mark_ob_total", e_mark_ob_total);
 	 //       model.addObject("result", result);
 	       
 			   return model; 
     	}
	 
	
		  
/*       else if(sem1>=3) {
     		branch=user.getBranch();
     		specialisation=user.getSpecialisation();
     List<Subject> subject=service.subjectByCourse_Branch(course, semester, branch, specialisation);
     model.addAttribute("student_id",student_id);
     model.addAttribute("semester",semester);
     model.addAttribute("subject",subject);
    
		   return "Faculty_Marksheet";      
 } */ 
    else {
     	ModelAndView model = new ModelAndView();
		 	model.setViewName("studentview/{faculty_name}");
     	return model;
     }
     
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

	 

	 
	 }	 
	
	
	
	
	
	
}
