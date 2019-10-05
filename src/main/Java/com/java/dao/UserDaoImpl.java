 package com.java.dao;

import java.util.List;

//import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.beans.Branch;
import com.java.beans.Course;
import com.java.beans.Image;
import com.java.beans.Result;
import com.java.beans.Subject;
import com.java.beans.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	public Session setSessionFactory(SessionFactory sessionFactory) {
    return sessionFactory.getCurrentSession();
                  }
	
	private Session getSession() {
		return sessionFactory.openSession();
	                           }
 
	
	public void saveUser(User user) {
		Session session = sessionFactory.getCurrentSession();
     	Transaction t = session.beginTransaction();
		
		session.save(user);
		t.commit();
		}
	
	public void updateUser(User user) {
     	Session session = sessionFactory.getCurrentSession();
     	Transaction t = session.beginTransaction();
     	session.update(user);
     	t.commit();
		
     	}
	
	@SuppressWarnings("deprecation")
	public List<User> checkLogin(String email, String password){
		System.out.println("In Check login");
		Session session = sessionFactory.getCurrentSession();
		boolean userFound = false;
		Transaction t = session.beginTransaction();
		String SQL_QUERY ="  from User as o where o.email=?1 and o.password=?2";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(1,email);
		query.setParameter(2,password);
		System.out.println(email);
		List<User> list = query.list();

		if ((list != null) && (list.size() > 0)) {
			userFound= true;
		}
		t.commit();
//		session.close();
		return list;              
   }
	 
	
	 @SuppressWarnings("deprecation")
		public boolean checkUser(String email, String security_question, String security_answer){
			System.out.println("In user check");
			Session session = sessionFactory.getCurrentSession();
			boolean userValid = false;
			Transaction t = session.beginTransaction();
			String SQL_QUERY ="  from User as o where o.email=?1 and o.security_question=?2 and security_answer=?3";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(1,email);
			query.setParameter(2,security_question);
			query.setParameter(3,security_answer);
			System.out.println(email);
			List list = query.list();

			if ((list != null) && (list.size() > 0)) {
				userValid= true;
			}
            t.commit();
		    return userValid;              
	   }
		
        
		@SuppressWarnings("warning")
		public int updatePassword(String email, String password) {
			System.out.println("In password reset User dao");
			Session session = sessionFactory.getCurrentSession();//sessionFactory.openSession();
		    System.out.println(email);
			System.out.println(password);
			Transaction t = session.beginTransaction();
			Query query = session.createQuery("update User set password=:pass where email=:email");
		    query.setParameter("pass", password);
		    query.setParameter("email", email);
		    int result = query.executeUpdate();
		        // Commit the transaction and close the session
		        t.commit();
		        System.out.println("No of rows updated: "+result);
		return result;
		}
        
         public User getUserById(int id) {
     		Session session = sessionFactory.getCurrentSession();		
     		Transaction t = session.beginTransaction();
     		User u = (User) session.load(User.class, new Integer(id));
     		
     		t.commit();
     		System.out.println("Person loaded successfully, Person details="+u);
     		return u;
     	}

     	
     	public void removeUser(int id) {
     		Session session = sessionFactory.getCurrentSession();
     		Transaction t = session.beginTransaction();
     		User u = (User) session.load(User.class, new Integer(id));
     		if(null != u){
     			session.delete(u);
     		}
     		System.out.println("Person deleted successfully, person details="+u);
     		t.commit();
     	}		

     	@SuppressWarnings("unchecked")
     	public List<User> faculty() {
     		Session session = sessionFactory.getCurrentSession();
     		@SuppressWarnings("deprecation")
     		Transaction t=session.beginTransaction();
     		
			List<User> faculty = session.createQuery("from User where role_type='Faculty'").list();
     		for(User u : faculty){
     			System.out.println("Person List::"+u);
     		}
     		t.commit();
     		return faculty;
     	}
     	@SuppressWarnings("unchecked")
     	public List<User> student() {
     		Session session = sessionFactory.getCurrentSession();
     		@SuppressWarnings("deprecation")
     		Transaction t=session.beginTransaction();
     		
			List<User> list = session.createQuery("from User where role_type='Student'").list();
     		for(User u : list){
     			System.out.println("Person List::"+u);
     		}
     		t.commit();
     		return list;
     	}
     	
    	@SuppressWarnings("unchecked")
     	public List<User> getStudentbyFaculty(String faculty_name){
     		System.out.println("In get student by faculty User dao");
     		Session session = sessionFactory.getCurrentSession();
     		System.out.println(faculty_name);
     		
     		Transaction t=session.beginTransaction();
     		
     		String SQL_QUERY ="  from User  where faculty_name=?1 ";
    		Query query = session.createQuery(SQL_QUERY);
    		query.setParameter(1,faculty_name);
    		
    		//System.out.println(faculty_name);
    	
			List<User> list = query.list();
    		for(User u : list){
     			System.out.println("Person List::"+u);
     		}
    		t.commit();
//    		session.close();
    		return list;              
       }
 //Dao implementation of course    	
    	public void saveCourse(Course course) {
    		Session session = sessionFactory.getCurrentSession();
         	Transaction t = session.beginTransaction();
    		
    		session.save(course);
    		t.commit();
    	}
		public void updateCourse(Course course) {
			Session session = sessionFactory.getCurrentSession();
	     	Transaction t = session.beginTransaction();
	     	session.update(course);
	     	t.commit();
		}
	 	public Course getCourseById(int id) {
	 		Session session = sessionFactory.getCurrentSession();		
     		Transaction t = session.beginTransaction();
     		Course c = (Course) session.load(Course.class, new Integer(id));
     		
     		t.commit();
     		System.out.println("Person loaded successfully, Person details="+c);
     		return c;
     	
	 	}
		public void deleteCourse(int id) {
			Session session = sessionFactory.getCurrentSession();
     		Transaction t = session.beginTransaction();
     		Course c = (Course) session.load(Course.class, new Integer(id));
     		if(null != c){
     			session.delete(c);
     		}
     		System.out.println("Person deleted successfully, person details="+c);
     		t.commit();
		}
        @SuppressWarnings("unchecked")
		public List<Course> course(){
        	Session session = sessionFactory.getCurrentSession();
     		
     		Transaction t=session.beginTransaction();
     		
			List<Course> list = session.createQuery("from Course").list();
     		for(Course c : list){
     			System.out.println("Person List::"+c);
     		}
     		t.commit();
     		return list;
        }
        
//Dao implementation of branch        
        public void saveBranch(Branch branch) {
    		Session session = sessionFactory.getCurrentSession();
         	Transaction t = session.beginTransaction();
    		
    		session.save(branch);
    		t.commit();
    	}
		public void updateBranch(Branch branch) {
			Session session = sessionFactory.getCurrentSession();
	     	Transaction t = session.beginTransaction();
	     	session.update(branch);
	     	t.commit();
		}
	 	public Branch getBranchById(int id) {
	 		Session session = sessionFactory.getCurrentSession();		
     		Transaction t = session.beginTransaction();
     		Branch b = (Branch) session.load(Branch.class, new Integer(id));
     		
     		t.commit();
     		System.out.println("Person loaded successfully, Person details="+b);
     		return b;
     	
	 	}
		public void deleteBranch(int id) {
			Session session = sessionFactory.getCurrentSession();
     		Transaction t = session.beginTransaction();
     		Branch b = (Branch) session.load(Branch.class, new Integer(id));
     		if(null != b){
     			session.delete(b);
     		}
     		System.out.println("Person deleted successfully, person details="+b);
     		t.commit();
		}
        @SuppressWarnings("unchecked")
		public List<Branch> branch(){
        	Session session = sessionFactory.getCurrentSession();
     		
     		Transaction t=session.beginTransaction();
     		
			List<Branch> list = session.createQuery("from Branch").list();
     		for(Branch b : list){
     			System.out.println("Person List::"+b);
     		}
     		t.commit();
     		return list;
        }
                
        
  //dao on subject      
        
       
    public void saveSubject(Subject subject) {
    		Session session = sessionFactory.getCurrentSession();
         	Transaction t = session.beginTransaction();
    		
    		session.save(subject);
    		t.commit();
    	}
		public void updateSubject(Subject subject) {
			Session session = sessionFactory.getCurrentSession();
	     	Transaction t = session.beginTransaction();
	     	session.update(subject);
	     	t.commit();
		}
	 	public Subject getSubjectById(int id) {
	 		Session session = sessionFactory.getCurrentSession();		
     		Transaction t = session.beginTransaction();
     		Subject sub = (Subject) session.load(Subject.class, new Integer(id));
     		
     		t.commit();
     		System.out.println("Person loaded successfully, Person details="+sub);
     		return sub;
     	
	 	}
		public void deleteSubject(int id) {
			Session session = sessionFactory.getCurrentSession();
     		Transaction t = session.beginTransaction();
     		Subject sub = (Subject) session.load(Subject.class, new Integer(id));
     		if(null != sub){
     			session.delete(sub);
     		}
     		System.out.println("Person deleted successfully, person details="+sub);
     		t.commit();
		}
        @SuppressWarnings("unchecked")
		public List<Subject> subject(){
        	Session session = sessionFactory.getCurrentSession();
     		
     		Transaction t=session.beginTransaction();
     		
			List<Subject> list = session.createQuery("from Subject").list();
     		for(Subject sub : list){
     			System.out.println("Person List::"+sub);
     		}
     		t.commit();
     		return list;
        }
        
        @SuppressWarnings("unchecked")
        public List<Subject> subjectByCourse(String course){
        		Session session = sessionFactory.getCurrentSession();
        		Transaction t=session.beginTransaction();
        		String SQL_QUERY ="  from Subject  where course=?1 ";
        		Query query = session.createQuery(SQL_QUERY);
        		query.setParameter(1,course);
        		List<Subject> list = query.list();
        		for(Subject sub : list){
         			System.out.println("subject by course List::"+sub);
         		}
        		t.commit();
        		return list;         
        }
        
        @SuppressWarnings("unchecked")
        public List<Subject> subjectBySemester(String semester){
        		Session session = sessionFactory.getCurrentSession();
        		Transaction t=session.beginTransaction();
        		String SQL_QUERY ="  from Subject  where semester=?1 ";
        		Query query = session.createQuery(SQL_QUERY);
        		query.setParameter(1,semester);
        		List<Subject> list = query.list();
        		for(Subject sub : list){
         			System.out.println("Person List::"+sub);
         		}
        		t.commit();
        		return list;         
        }
        
        @SuppressWarnings("unchecked")
        public List<Subject> subjectByBranch(String semester, String branch,String specialisation){
        		Session session = sessionFactory.getCurrentSession();
        		Transaction t=session.beginTransaction();
        		String SQL_QUERY ="  from Subject  where semester=?1 and branch=?2 and specialisation=?3 ";
        		Query query = session.createQuery(SQL_QUERY);
        		query.setParameter(1,semester);
        		query.setParameter(2,branch);
        		query.setParameter(3,specialisation);
        		List<Subject> list = query.list();
        		for(Subject sub : list){
         			System.out.println("Person List::"+sub);
         		}
        		t.commit();
        		return list;         
        }
        @SuppressWarnings("unchecked")
        public List<Subject> subjectByCourse_Branch(String course,String semester, String branch,String specialisation){
        		Session session = sessionFactory.getCurrentSession();
        		Transaction t=session.beginTransaction();
        		String SQL_QUERY ="from Subject where course=?1 and semester=?2 and branch=?3 and specialisation=?4";
        		Query query = session.createQuery(SQL_QUERY);
        		query.setParameter(1,course);
        		query.setParameter(2,semester);
        		query.setParameter(3,branch);
        		query.setParameter(4,specialisation);
        		List<Subject> list = query.list();
        		for(Subject sub : list){
         			System.out.println("Subject by course semester branch  List::"+sub);
         		}
        		t.commit();
        		return list;         
        }
        
    /*    @SuppressWarnings("unchecked")
        public List<Subject> subjectByCourse_Semester(String course,String semester){
        		Session session = sessionFactory.getCurrentSession();
        		Transaction t=session.beginTransaction();
        		String SQL_QUERY ="from Subject where course=?1 and semester=?2 ";
        		Query query = session.createQuery(SQL_QUERY);
        		query.setParameter(1,course);
        		query.setParameter(2,semester);
        		List<Subject> list = query.list();
        		for(Subject sub : list){
         			System.out.println("Subject by course semester List::"+sub);
         		}
        		t.commit();
        		return list;         
        }
      */  
        
        
//dao on result      
        
        
       
        public void save(Result result){
                Session session = sessionFactory.getCurrentSession();
                Transaction t = session.beginTransaction();
                
                    session.save(result);
                
                t.commit();
            }
        public void updateResult(Result result) {
    			Session session = sessionFactory.getCurrentSession();
    	     	Transaction t = session.beginTransaction();
    	     	session.update(result);
    	     	t.commit();
    		}
    	 	public List<Result> getResultById(int student_id) {
    	 		Session session = sessionFactory.getCurrentSession();		
         		Transaction t = session.beginTransaction();
         		String SQL_QUERY ="  from Result  where student_id=?1 ";
         	    Query query = session.createQuery(SQL_QUERY);
        		query.setParameter(1,student_id);
        		List<Result> list = query.list();	
         		for(Result result : list){
         			System.out.println("Person List::"+result);
         		}
         		t.commit();
         		System.out.println("Result of student loaded successfully, Person details="+list);
         		return list;
         	
    	 	}
    		public void deleteResult(int student_id) {
    			Session session = sessionFactory.getCurrentSession();
         		Transaction t = session.beginTransaction();
         		Result result = (Result) session.load(Result.class, new Integer(student_id));
         		if(null != result){
         			session.delete(result);
         		}
         		System.out.println("Person deleted successfully, person details="+result);
         		t.commit();
    		}
    		@SuppressWarnings("unchecked")
         	public List<Result> result() {
         		Session session = sessionFactory.getCurrentSession();
         		Transaction t=session.beginTransaction();
         		List<Result> list = session.createQuery("from Result").list();
         		for(Result u : list){
         			System.out.println("Result List::"+u);
         		}
         		t.commit();
         		return list;
         	}
         	 
    		
    		
    		public List<Result> getResultBySubject_id(int student_id,String subject_id) {
    	 		Session session = sessionFactory.getCurrentSession();		
    	 		Transaction t = session.beginTransaction();
    			String SQL_QUERY ="  from Result  where student_id =?1 and subject_id=?2";
    			Query query = session.createQuery(SQL_QUERY);
    			query.setParameter(1,student_id);
    			query.setParameter(2,subject_id);
    			System.out.println(student_id);
    			List<Result> list = query.list();

    			
    			t.commit();
//    			session.close();
    			return list;              
    	 	}
    		
    	 	public Result getResultByStudent_Id(int id) {
    	 		Session session = sessionFactory.getCurrentSession();		
         		Transaction t = session.beginTransaction();
         		Result res = (Result) session.load(Result.class, new Integer(id));
         		
         		t.commit();
         		System.out.println("Person loaded successfully, Person details="+res);
         		return res;
         	
    	 	}
    	 	public Result getResultByRId(int id) {
    	 		
    		 		Session session = sessionFactory.getCurrentSession();		
    	     		Transaction t = session.beginTransaction();
    	     		Result result = (Result) session.load(Result.class, new Integer(id));
    	     		
    	     		t.commit();
    	     		System.out.println("Person loaded successfully, Person details="+result);
    	     		return result;
    	     	
    		 	}
    	 	
   //operation on image
    	 	public void saveImage(Image image) {
    			Session session = sessionFactory.getCurrentSession();
    	     	Transaction t = session.beginTransaction();
    			
    			session.save(image);
    			t.commit();
    			}
    	 	
    	 	 @SuppressWarnings("unchecked")
    			public List<Image> image(){
    	        	Session session = sessionFactory.getCurrentSession();
    	     		
    	     		Transaction t=session.beginTransaction();
    	     		
    				List<Image> list = session.createQuery("from Image").list();
    	     		for(Image b : list){
    	     			System.out.println("Image List::"+b);
    	     		}
    	     		t.commit();
    	     		return list;
    	        }
    	 	
    	 
    		public Image getImageById(int id) {
    			Image img = getSession().get(Image.class, id);
    			return img;	
    		}
    		

}