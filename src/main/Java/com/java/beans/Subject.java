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
@Table(name="subject",uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID") })
@Proxy(lazy=false) 
public class Subject {
	 @Id  
	    @GeneratedValue(strategy=GenerationType.IDENTITY)  
	  @Column(name = "id",  nullable=false, unique=true)
private int id;
    @Column(name="subject_id")	 
private String subject_id;
	 @Column(name="subject_name")
private String subject_name;
	 @Column(name="external_marks")
private String external_marks;
	 @Column(name="internal_marks")
private String internal_marks;
	 @Column(name="credit")
private int credit;
	 @Column(name="semester")
private String semester;
	 @Column(name="branch")
private String branch;
	 @Column(name="specialisation")
private String specialisation;
	 @Column(name="course")	 
private String course;




	public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
	public String getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	
	public String getExternal_marks() {
		return external_marks;
	}
	public void setExternal_marks(String external_marks) {
		this.external_marks = external_marks;
	}
	public String getInternal_marks() {
		return internal_marks;
	}
	public void setInternal_marks(String internal_marks) {
		this.internal_marks = internal_marks;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getSpecialisation() {
		return specialisation;
	}
	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Subject [subject_id=" + subject_id + ", subject_name=" + subject_name + ", semester=" + semester
				+ ", branch=" + branch + ", specialisation=" + specialisation + ", course=" + course + "]";
	}



}
