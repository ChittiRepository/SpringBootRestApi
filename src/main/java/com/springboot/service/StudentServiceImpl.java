package com.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.apache.commons.lang.StringUtils;

import com.springboot.helper.Validator;
import com.springboot.model.Student;
import com.springboot.model.Student.EducationType;
import com.springboot.util.StudentExceptionType;



@Service("userService")
public class StudentServiceImpl implements StudentService{
	private Validator validator=new Validator();
	private static List<Student> liststudent = new ArrayList<>();
private static List<Student> populateDummyUsers(){
		Student student=new Student();
		student.setFirstName("ramana");
		student.setLastName("venkat");
		student.setAge("25");
		student.setMobile("9940302548");
		student.setEmailId("tech.ramanainfo@gmail.com");
		student.setEducation(EducationType.BSC);
		student.setPermanentAddress("Kadapa");	
		student.setTemporaryAddress("chennai");
		
		Student student1=new Student();
		student1.setFirstName("rama");
		student1.setLastName("siva");
		student1.setAge("18");
		student1.setMobile("9940302549");
		student1.setEducation(EducationType.INTER);
		student.setEmailId("tech.ramana@gmail.com");
		student1.setPermanentAddress("sholinganallur");	
		student1.setTemporaryAddress("chennai");
		liststudent.add(student);
		liststudent.add(student1);
		
		return liststudent;
	}

	@Override
	public List<Student> findByName(String firstname) {
		
		List<Student> List= populateDummyUsers();
		List<Student> resList=List.stream().filter(Student-> Student.getFirstName().equals(firstname)).collect(Collectors.toList());
	
		return resList;
		}

	@Override
	public List<Student> findAllUsers() {
	
		return populateDummyUsers();
	}

	@Override
	public List<Student> findByAge(String age) {
		List<Student> List= populateDummyUsers();
		List<Student> resList=List.stream().filter(Student-> Student.getAge().equals(age)).collect(Collectors.toList());
		
		
		return resList;
	}

	@Override
	public List<Student> findByEduction(Student.EducationType education) {
		
		List<Student> List= populateDummyUsers();
		List<Student> resList=List.stream().filter(Student-> Student.getEducation().equals(education)).collect(Collectors.toList());
		
	return resList;
	}
	



@Override
public boolean createUser(Student stu) {
	// TODO Auto-generated method stub
	boolean res=false;
	boolean eresult= validator.validateEmailAddress(stu.getEmailId());
	boolean fnres=validator.validateFname(stu.getFirstName());
	boolean mres= validator.validateMobileNumber(stu.getMobile());
	boolean ares= validator.validateAddress(stu.getTemporaryAddress(), stu.getPermanentAddress());
	boolean agres= validator.validateAge(stu.getAge());
	if(eresult && fnres && mres && ares && agres){
		System.out.println("Save Operation Calleed");
		res=true;
		
	}
	return res;
}


}
