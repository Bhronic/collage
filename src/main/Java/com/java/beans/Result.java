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
@Table(name="result",uniqueConstraints = {
        @UniqueConstraint(columnNames = "id") })
@Proxy(lazy=false) 
public class Result {
	 @Id  
	    @GeneratedValue(strategy=GenerationType.IDENTITY)  
	  @Column(name = "id",  nullable=false, unique=true)
private int id;
	 @Column(name = "student_id",  nullable=false, unique=true)
private int student_id;
	 @Column(name="subject_id",nullable=false)
private String subject_id; 
	 
	 @Column(name="subject_name",nullable=false)
private String subject_name;
	 @Column(name="semester",nullable=false)
private String semester;
	 @Column(name="external_marks_ob")
private String external_marks_ob;

	 @Column(name="internal_marks_ob")
private String internal_marks_ob;
	 @Column(name="credit")
private int credit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
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

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getExternal_marks_ob() {
		return external_marks_ob;
	}

	public void setExternal_marks_ob(String external_marks_ob) {
		this.external_marks_ob = external_marks_ob;
	}

	public String getInternal_marks_ob() {
		return internal_marks_ob;
	}

	public void setInternal_marks_ob(String internal_marks_ob) {
		this.internal_marks_ob = internal_marks_ob;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	
	public Result(int id, int student_id, String subject_id, String subject_name, String external_marks_ob,
			String internal_marks_ob, int credit) {
		super();
		this.id = id;
		this.student_id = student_id;
		this.subject_id = subject_id;
		this.subject_name = subject_name;
		this.external_marks_ob = external_marks_ob;
		this.internal_marks_ob = internal_marks_ob;
		this.credit = credit;
	}

	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Result [id=" + id + ", student_id=" + student_id + ", subject_id=" + subject_id + ", subject_name="
				+ subject_name + ", external_marks=" + external_marks_ob + ", internal_marks=" + internal_marks_ob + "]";
	}
	 
	 
	 
	 
}