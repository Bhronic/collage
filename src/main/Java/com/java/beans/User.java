package com.java.beans;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Proxy;


@Entity()
@Table(name="user",uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID"),
        @UniqueConstraint(columnNames = "EMAIL") })
@Proxy(lazy=false) 
public class User {
	 @Id  
	    @GeneratedValue(strategy=GenerationType.IDENTITY)  
	  @Column(name = "id",  nullable=false, unique=true)
private int id;
	 @Column(name="name") 
private String name;
	 @Column(name="dob") 
private String dob;
	 @Column(name="gender") 
private String gender;
	 @Column(name="address") 
private String address;
	 @Column(name="city") 
private String city;
	 @Column(name="state") 
private String state;
	 @Column(name="pincode") 
private String pincode;
	 @Column(name="contact_no") 
private String contact_no;
	 @Column(name="email")
private String email;
	 @Column(name="password")
private String password;
	 @Column(name="role_type") 
private String role_type;
	 @Column(name="course") 
private String course;
	 @Column(name="branch") 
private String branch;
	 @Column(name="faculty_name") 
private String faculty_name;
	 @Column(name="admission_year")
private String admission_year;	 
	 @Column(name="semester") 
private String semester;
	 @Column(name="section") 
private String section;
	 @Column(name="specialisation") 
 private String specialisation;    
	 @Column(name="security_question")
private String security_question;
	 @Column(name="security_answer")
private String security_answer;
	 
/*@ManyToMany(cascade = {CascadeType.ALL})
  @JoinTable(name="result", 
  joinColumns= {@JoinColumn(name="student_id")},  inverseJoinColumns= {@JoinColumn(name="id")})  
	*/ 
//private List<Result> result;  
	 
	 
	 
	 
	 
	 
	 
	 
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole_type() {
		return role_type;
	}
	public void setRole_type(String role_type) {
		this.role_type = role_type;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	public String getFaculty_name() {
		return faculty_name;
	}
	public void setFaculty_name(String faculty_name) {
		this.faculty_name = faculty_name;
	}
	public String getAdmission_year() {
		return admission_year;
	}
	public void setAdmission_year(String admission_year) {
		this.admission_year = admission_year;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	
	public String getSpecialisation() {
		return specialisation;
	}
	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}
	public String getSecurity_question() {
		return security_question;
	}
	public void setSecurity_question(String security_question) {
		this.security_question = security_question;
	}
	public String getSecurity_answer() {
		return security_answer;
	}
	public void setSecurity_answer(String security_answer) {
		this.security_answer = security_answer;
	}
	
	
	
/*	public List<Result> getResult() {
		return result;
	}
	public void setResult(List<Result> result) {
		this.result = result;
	}     */
	public User(int id, String name, String dob, String gender, String address,String city, String state, 
			String pincode, String contact_no, String email, String password,
		    String role_type, String course, String branch,String admission_year, String semester,String section, String security_question,
			String security_answer) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.contact_no = contact_no;
		this.email = email;
		this.password = password;
		this.role_type = role_type;
		this.course = course;
		this.branch = branch;
		this.admission_year=admission_year;
		this.semester = semester;
		this.section=section;
		this.security_question = security_question;
		this.security_answer = security_answer;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", contact_no=" + contact_no
				+ ", email=" + email + ", password=" + password + ", role_type=" + role_type + ", course=" + course
				+ ", branch=" + branch + ", faculty_name=" + faculty_name + ", admission_year=" + admission_year
				+ ", semester=" + semester + ", section=" + section + ", security_question=" + security_question
				+ ", security_answer=" + security_answer + "]";
	}
	
	 
	 
	 
}
