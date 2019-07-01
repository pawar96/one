package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import com.app.pojo.Student;

public interface IStudentDao {
	Student validateUser(String email,String password);
	String InserData(Student s);
	 List<Student> getall();
	
	

}
