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
@Table(name="course",uniqueConstraints = {
        @UniqueConstraint(columnNames = "course_id") })
@Proxy(lazy=false) 
public class Course {
	 @Id  
	    @GeneratedValue(strategy=GenerationType.IDENTITY)  
	  @Column(name = "course_id",  nullable=false, unique=true)
private int course_id;
	 @Column(name="course_name") 
private String course_name;
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_name=" + course_name + "]";
	}
	 
	 
	 
	 
}