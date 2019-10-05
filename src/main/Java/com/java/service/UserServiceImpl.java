package com.java.service;

import java.util.List;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.beans.Branch;
import com.java.beans.Course;
import com.java.beans.Image;
import com.java.beans.Result;
import com.java.beans.Subject;
import com.java.beans.User;
import com.java.dao.UserDao;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	 @Autowired
	    private UserDao dao;
	 
	
	public void saveUser(User u) {
		// TODO Auto-generated method stub
 
		    dao.saveUser(u);
	}
	
	public List<User> checkLogin(String email, String password){
        System.out.println("In Service class...Check Login");
        return dao.checkLogin(email, password);
 }


	public boolean checkUser(String email, String security_question, String security_answer){
        System.out.println("In Service class...Check User");
        return dao.checkUser(email,security_question,security_answer );
 }
	
	@Transactional
	public int updatePassword(String email, String password) {
		System.out.println("In Service class...Update Password");
		return dao.updatePassword(email,password);
	}
	
	@Transactional
	public void updateUser(User u) {
		dao.updateUser(u);
	}

    @Transactional
	public User getUserById(int id) {
		return dao.getUserById(id);
	}

	
	@Transactional
	public void removeUser(int id) {
		dao.removeUser(id);
	}
	@Transactional
	public List<User> faculty() {
		return dao.faculty();
	}
	@Transactional
	public List<User> student() {
		return dao.student();
	}
	@Transactional
	public List<User> getStudentbyFaculty(String faculty_name){
		return dao.getStudentbyFaculty(faculty_name);
	}
	
//service implementation on course	
	@Transactional
	public void saveCourse(Course course) {
		dao.saveCourse(course);
	}
	@Transactional
	public void updateCourse(Course course) {
		dao.updateCourse(course);
	}
	@Transactional
 	public Course getCourseById(int id) {
 		return dao.getCourseById(id);
 	}
	@Transactional
	public void deleteCourse(int id) {
		dao.deleteCourse(id);
	}
	
	@Transactional
    public List<Course> course(){
    	return dao.course();
    }
//Service implementation of branch
	@Transactional
	public void saveBranch(Branch branch) {
		dao.saveBranch(branch);
	}
	@Transactional
	public void updateBranch(Branch branch) {
		dao.updateBranch(branch);
	}
	@Transactional
 	public Branch getBranchById(int id) {
 		return dao.getBranchById(id);
 	}
	@Transactional
	public void deleteBranch(int id) {
		dao.deleteBranch(id);
	}
	
	@Transactional
    public List<Branch> branch(){
    	return dao.branch();
    }
//Service implemenetation of subject
	@Transactional
	public void saveSubject(Subject subject) {
		dao.saveSubject(subject);
	}
	@Transactional
	public void updateSubject(Subject subject) {
		dao.updateSubject(subject);
	}
	@Transactional
 	public Subject getSubjectById(int id) {
 		return dao.getSubjectById(id);
 	}
	@Transactional
	public void deleteSubject(int id) {
		dao.deleteSubject(id);
	}
	
	@Transactional
    public List<Subject> subject(){
    	return dao.subject();
    }
	@Transactional
	public List<Subject> subjectByCourse(String course){
		return dao.subjectByCourse(course);
	}
	@Transactional
    public List<Subject> subjectBySemester(String semester){
    	return dao.subjectBySemester(semester);
    }
	@Transactional
	public List<Subject> subjectByBranch(String semester, String branch,String specialisation){
    	return dao.subjectByBranch(semester,branch,specialisation);
    }
	@Transactional
	public List<Subject> subjectByCourse_Branch(String course,String semester, String branch,String specialisation){
		return dao.subjectByCourse_Branch(course, semester, branch, specialisation);
	}
	
//Service implemenetation of result
	/*	@Transactional
		public void saveResult(Result result) {
		dao.saveResult(result);
		}*/
		@Transactional
		public void updateResult(Result result) {
			dao.updateResult(result);
		}
		@Transactional
	 	public List<Result> getResultById(int student_id) {
	 		return dao.getResultById(student_id);
	 	}
		@Transactional
		public void deleteResult(int student_id) {
			dao.deleteResult(student_id);
		}
		
	/*	@Transactional
	    public List<Result> result(int student_id){
	    	return dao.result(student_id);
	    }	*/
		@Transactional
		public void save(Result result) {
		 dao.save(result);
		}
		@Transactional
		public List<Result> result(){
			return dao.result();
		}
		@Transactional
		public List<Result> getResultBySubject_id(int student_id,String subject_id){
			return dao.getResultBySubject_id( student_id,subject_id);
		}
		@Transactional
	 	public Result getResultByRId(int id) {
	 		return dao.getResultByRId(id);
	 	}
		
//operation on image
		@Transactional
		public void saveImage(Image image) {
			dao.saveImage(image);
		}
		@Transactional
	    public List<Image> image(){
	    	return dao.image();
	    }
		@Transactional
	 	public Image getImageById(int id) {
	 		return dao.getImageById(id);
	 	}
}
