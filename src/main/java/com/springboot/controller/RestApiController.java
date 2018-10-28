package com.springboot.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Student;
import com.springboot.service.StudentService;
import com.springboot.util.StudentExceptionType;

@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	StudentService studentService;

	//*******************Retrieve All******************//

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> listAllUsers() {
		List<Student> liststudent = studentService.findAllUsers();

		if (liststudent.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);

		}
		return new ResponseEntity<List<Student>>(liststudent, HttpStatus.OK);
	}

	//**************Retrieve Userinfo By name*****************//
	

	@RequestMapping(value = "/user/firstname/{firstname}", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getfindByName(@PathVariable("firstname") String firstname) {

		List<Student> liststudent = studentService.findByName(firstname);
		ResponseEntity<List<Student>> resentity;

		if (liststudent != null) {
			resentity = new ResponseEntity<List<Student>>(liststudent, HttpStatus.OK);
		} else {

			resentity = new ResponseEntity<List<Student>>(liststudent, HttpStatus.NO_CONTENT);
		}
		return resentity;
	}

	//********************Retrieve Userinfo By age*********************//


	@RequestMapping(value = "/user/age/{age}", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getfindByAge(@PathVariable("age") String age) {

		List<Student> liststudent = studentService.findByAge(age);
		ResponseEntity<List<Student>> resentity;

		if (liststudent.size() == 0) {

			resentity = new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);

		} else {
			resentity = new ResponseEntity<List<Student>>(liststudent, HttpStatus.OK);
		}
		return resentity;
	}

	//******************Retrieve Userinfo By education*******************//
	

	
	 @RequestMapping(value = "/user/education/{education}", method =
	 RequestMethod.GET) 
	 public ResponseEntity<List<Student>> getfindByEducation(@PathVariable("education") Student.EducationType education) {
	  
	  List<Student> liststudent = studentService.findByEduction(education);
	  
	  ResponseEntity<List<Student>> resentity;
	  
	  if (liststudent!=null) {
	  
	  resentity = new ResponseEntity<>(liststudent, HttpStatus.OK); } 
	  else {
	  resentity = new ResponseEntity<List<Student>>(liststudent,HttpStatus.NO_CONTENT); 
	  }
	  return resentity;
	 }
	 

	@RequestMapping(value = "/user/createuser", method = RequestMethod.POST)
	public ResponseEntity<Student> createUser(@RequestBody Student stu) throws URISyntaxException {
		ResponseEntity<Student> resp;
		boolean res = studentService.createUser(stu);
		if (res) {
			return resp = new ResponseEntity<Student>(HttpStatus.OK);
		} else {
			return resp = new ResponseEntity(new StudentExceptionType("Not proper format values").getErrorMessage(),
					HttpStatus.BAD_REQUEST);
		}
	}

}