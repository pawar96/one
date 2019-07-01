package com.app.pojo;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {
	private int id;
	private String name;
	private String lastname;
	private String subject;
	private String email;
	private String date;
	
	
	public Student() {
		super();
		
	}


	public Student(String name, String lastname, String subject, String email, String date) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.subject = subject;
		this.email = email;
		this.date = date;
	}
	
	
	public Student(int id, String name, String lastname, String subject, String email, String date) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.subject = subject;
		this.email = email;
		this.date = date;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

@Column(name = "name",length = 10)
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@Column(name="lastname",length=10)
	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	@Column(name="subject",unique=true)
	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}

@Column(name="email",unique=true)
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

@Column(name="date")
	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", lastname=" + lastname + ", subject=" + subject + ", email="
				+ email + ", date=" + date + "]";
	}
	
	
	
	
	
	
	
	

}
