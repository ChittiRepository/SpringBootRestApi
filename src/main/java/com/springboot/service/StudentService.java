package com.springboot.service;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.springboot.model.Student;


public interface StudentService {
	
   List<Student> findByName(String firstname);
	
   List<Student> findAllUsers();
	
   List<Student> findByAge(String age);
   
   List<Student> findByEduction(Student.EducationType education);
   
   boolean createUser(Student stu);
	
	
}
