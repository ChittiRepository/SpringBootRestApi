package com.springboot.util;


public class StudentExceptionType extends RuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	

    public  StudentExceptionType(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
