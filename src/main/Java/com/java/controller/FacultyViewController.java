package com.java.controller;
import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.java.beans.Branch;
import com.java.beans.Course;
import com.java.beans.Result;
import com.java.beans.ResultForm;
import com.java.beans.Subject;
import com.java.beans.User;
import com.java.service.UserService;

@Controller
public class FacultyViewController {
	@Autowired
	public UserService service;
	 
	
	@RequestMapping(value = "/studentview/{faculty_name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getStudentbyFaculty(@PathVariable String faculty_name, @ModelAttribute("User") User u,Model model) {
		//String faculty_name = u.getName();
		System.out.println(faculty_name);
		List<User> studentview = service.getStudentbyFaculty(faculty_name);
	    model.addAttribute("user", new User());
		model.addAttribute("studentview", studentview);
		return "studentview";
	}
	@RequestMapping(value="/editStudent/{id}", method=RequestMethod.GET)
	public String editUserPage(@PathVariable Integer id, Model model) {
	   
	    User user = service.getUserById(id);
	    model.addAttribute("user", user);
	    return "edit_studentinfo";
	}

	 @RequestMapping(value="/updateStudent", method=RequestMethod.POST)
	public String edditingUser(@ModelAttribute("user") User u, Model model) {

	    String role=u.getRole_type();
	    String faculty_name=u.getFaculty_name();
	    model.addAttribute("faculty_name", faculty_name);
	    System.out.println(role);
	    service.updateUser(u);

		   return "redirect:/studentview/{faculty_name}";
	   
	 }
	 @RequestMapping(value="/deleteUpdate/{id}", method=RequestMethod.GET)
	 public String deleteUser(@PathVariable Integer id, Model model,@ModelAttribute("user") User u) {
	     service.removeUser(id);
	     
	     String faculty_name=u.getFaculty_name();
		    model.addAttribute("faculty_name", faculty_name);
	     String message = "User successfully deleted.";
	     
	     return ("redirect:/studentview/{faculty_name}");
	     
	 }	

/*	//this is working code but need some modification which is goin on so making duplicate copy..... 
 * @RequestMapping(value = "/add_result", method = RequestMethod.GET)
	    public String addResult(HttpServletRequest request,Model model) {
	        int id = Integer.parseInt(request.getParameter("id"));
	        User user = service.getUserById(id);
	        String  faculty_name=user.getFaculty_name();
	        String branch=user.getBranch();
	        String semester=user.getSemester();
	        int student_id=id;
	        List<Result> result = service.result();
	        int sid=0;
	        String sem=null;
	        for (Result x : result) {
			 sid=x.getStudent_id();
			 
			 sem=x.getSemester();
			 
			 if(sid==student_id) 
				 break;
	        }
			  if( sid==student_id && semester.equals(sem) ) {
	        	model.addAttribute("semester",semester);
	        	model.addAttribute("id",student_id);
	        	String msg="Result is already added you can edit";
	        	model.addAttribute("msg", msg);
				return ("redirect:/view_result?id="+id+"");
			}
	        else
	        {  
	        List<Subject> subject=service.subjectBySemester(semester);
	        model.addAttribute("student_id",student_id);
	        model.addAttribute("semester",semester);
	        model.addAttribute("subject",subject);
	       
			   return "Faculty_result_add";      
	    }
	        
	    }
	*/
	 
	 @RequestMapping(value = "/add_result", method = RequestMethod.GET)
	    public String addResult(HttpServletRequest request,Model model) {
	        int id = Integer.parseInt(request.getParameter("id"));
	        User user = service.getUserById(id);
	        String  faculty_name=user.getFaculty_name();
	        String branch=user.getBranch();
	        String specialisation=user.getSpecialisation();
	        String semester=user.getSemester();
	        String course=user.getCourse();
	        int sem1=Integer.parseInt(semester);
	        int student_id=id;
	        List<Result> result = service.result();
	        int sid=0;
	        String sem=null;
	        for (Result x : result) {
			 sid=x.getStudent_id();
			 
			 sem=x.getSemester();
			 
			 if(sid==student_id) 
				 break;
	        }
			  if( sid==student_id && semester.equals(sem) ) {
	        	model.addAttribute("semester",semester);
	        	model.addAttribute("id",student_id);
	        	String msg="Result is already added you can edit";
	        	model.addAttribute("msg", msg);
				return ("redirect:/view_result?id="+id+"");
			}
	        else if (sem1<=2) {
	        		branch="null";
	        		specialisation="null";
	        		List<Subject> subject=service.subjectByCourse_Branch(course, semester, branch, specialisation);
	        		model.addAttribute("student_id",student_id);
	    	        model.addAttribute("semester",semester);
	    	        model.addAttribute("subject",subject);
	    	       
	    			   return "Faculty_result_add"; 
	        	}
			  
	        else if(sem1>=3) {
	        		branch=user.getBranch();
	        		specialisation=user.getSpecialisation();
	        List<Subject> subject=service.subjectByCourse_Branch(course, semester, branch, specialisation);
	        model.addAttribute("student_id",student_id);
	        model.addAttribute("semester",semester);
	        model.addAttribute("subject",subject);
	       
			   return "Faculty_result_add";      
	    }
	        else {
	        	return ("redirect:/studentview/{faculty_name}");
	        }
	     }
	 
	 @SuppressWarnings("unchecked")
	 @RequestMapping(value = "/saveResult", method = RequestMethod.POST)
	 public String save(@ModelAttribute ResultForm resultForm,Model model) {
	//		User user=service.getUserById(id);
			List<Result> results = resultForm.getResults();
			int x=0;
			
			if(null != results && results.size() > 0) {
			
				for (Result result : results) {
			service.save(result);
		 x=	result.getStudent_id();
			
				}
			}
			model.addAttribute("id",x);
			return "redirect:/view_result?id="+x+"";
		}
	
	 	@RequestMapping(value="/view_result", method=RequestMethod.GET)
		public String resultView(HttpServletRequest request,Model model) {
		 	int id = Integer.parseInt(request.getParameter("id"));
	        User user = service.getUserById(id);  
	        String faculty_name=user.getFaculty_name();
	        int student_id=id;
	        List< Result> result=service.getResultById(student_id); 
	        String msg="Marks Obtained by Student";
	        model.addAttribute("msg", msg);
		    model.addAttribute("user", user);
		    model.addAttribute("result", result);
		    model.addAttribute("faculty_name", faculty_name);
		    return "faculty_result_view";
		}
	 
	
	 @RequestMapping(value="/editResult/{id}", method=RequestMethod.GET)
		public String editResult(@PathVariable Integer id, Model model) {
		   
		    Result result = service.getResultByRId(id);
		    model.addAttribute("result", result);
		    return "edit_result";
		}

		 @RequestMapping(value="/updateResult", method=RequestMethod.POST)
		 public String edditingResult(@ModelAttribute("result") Result result, Model model) {
	
			 int id=result.getStudent_id();
			 
			 User user=service.getUserById(id);
			 String role=user.getRole_type();
			 String faculty_name=user.getFaculty_name();
			 model.addAttribute("faculty_name", faculty_name);
			 System.out.println(role);
			 service.updateResult(result);
			 return "redirect:/studentview/{faculty_name}";
		   
		 }
	 
		 @RequestMapping(value = "/total_result", method = RequestMethod.GET)
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
	//    	        int per=0;
	 //   	        per=(607/750)*100;
	    	        //per=(mark_obtain*(1/maximum_mark))*100;
	    	        double percentage =(double)mark_obtain / maximum_mark;
	    	        double per=percentage*100;
	    	        double s = Math.round(per * 100.0) / 100.0;
	    		      
	    	        System.out.println(percentage);
	    	        System.out.println(per);
	    	        System.out.println(s);
	    	        model.addAttribute("faculty_name",faculty_name);
	        		model.addAttribute("maximum_mark",maximum_mark);
	        		model.addAttribute("student_id",student_id);
	    	        model.addAttribute("semester",semester);
	    	        model.addAttribute("e_mark_ob",e_mark_ob);
	    			model.addAttribute("i_mark_ob",i_mark_ob);
	    			model.addAttribute("mark_obtain",mark_obtain);  
	    			model.addAttribute("per",s);
	    			model.addAttribute("result",result);  
	        	}
			  
		 
		        return "faculty_student_result_total";
		 }
	 
	
		 
		 
		 
	
		 
		 
		 
}