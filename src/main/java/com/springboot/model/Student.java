package com.springboot.model;

public class Student {

	private String firstName;

	private String lastName;

	private String age;

	private Student.EducationType education;

	private String mobile;

	private String emailId;

	private String temporaryAddress;

	private String permanentAddress;

	public Student.EducationType getEducation() {
		return education;
	}

	public void setEducation(Student.EducationType education) {
		this.education = education;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getTemporaryAddress() {
		return temporaryAddress;
	}

	public void setTemporaryAddress(String temporaryAddress) {
		this.temporaryAddress = temporaryAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public enum EducationType {
		SSC("SSC"), INTER("INTER"), BSC("BSC");
		private String education;

		private EducationType(String education) {
			this.education = education;

		}

		
	}

}
