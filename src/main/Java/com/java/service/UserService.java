package com.java.service;

import java.util.List;

import com.java.beans.Branch;
import com.java.beans.Course;
import com.java.beans.Image;
import com.java.beans.Result;
import com.java.beans.Subject;
import com.java.beans.User;

public interface UserService {
	public void saveUser(User u);
	public List<User> checkLogin(String email, String password);
	public boolean checkUser(String email, String security_question, String security_answer);
	public int updatePassword(String email, String password);
	public void updateUser(User u);
	
	public User getUserById(int id);
	public void removeUser(int id);
	public List<User> faculty();
	public List<User> student();
	public List<User> getStudentbyFaculty(String faculty_name);
	
//curd operation on Course
	public void saveCourse(Course course);
	public void updateCourse(Course course);
 	public Course getCourseById(int id);
	public void deleteCourse(int id);
    public List<Course> course();
    
  //curd operation on Branch        
    	public void saveBranch(Branch branch);
  		public void updateBranch(Branch branch);
  	 	public Branch getBranchById(int id);
  		public void deleteBranch(int id);
        public List<Branch> branch();
    
//curd operation on Subject
        public void saveSubject(Subject subject);
		public void updateSubject(Subject subject);
	 	public Subject getSubjectById(int id);
		public void deleteSubject(int id);
        public List<Subject> subject();
        public List<Subject> subjectByCourse(String course);
        public List<Subject> subjectBySemester(String semester);
        public List<Subject> subjectByBranch(String semester, String branch,String specialisation);
        public List<Subject> subjectByCourse_Branch(String course,String semester, String branch,String specialisation);
        
//curd operation on result
       
 		public void updateResult(Result result);
 	 	public List<Result> getResultById(int student_id);
 		public void deleteResult(int student_id);
        public void save(Result result);
        public List<Result> result();
        public List<Result> getResultBySubject_id(int student_id,String subject_id);
        public Result getResultByRId(int id);
        
//operation on image
        public void saveImage(Image image);
        public List<Image> image();
        public Image getImageById(int id);
}
