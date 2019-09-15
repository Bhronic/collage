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
@Table(name="branch",uniqueConstraints = {
        @UniqueConstraint(columnNames = "id") })
@Proxy(lazy=false) 
public class Branch {
	 @Id  
	    @GeneratedValue(strategy=GenerationType.IDENTITY)  
	  @Column(name = "id",  nullable=false, unique=true)
	 private int id;
	 @Column(name="branch_name",nullable=false)
private String branch_name;
	 @Column(name="specialisation")
	 private String specialisation;
	 @Column(name="course_name",nullable=false)
	 private String course_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getSpecialisation() {
		return specialisation;
	}
	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	@Override
	public String toString() {
		return "Branch [id=" + id + ", branch_name=" + branch_name + ", specialisation=" + specialisation
				+ ", course_name=" + course_name + "]";
	}
	 
	 
}
