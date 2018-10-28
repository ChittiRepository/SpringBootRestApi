package com.springboot.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class Validator {
	 private Pattern regexPattern;
	    private Matcher regMatcher;
	  public boolean validateEmailAddress(String email) {
		  	boolean res=false;
	        regexPattern = Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
	        regMatcher   = regexPattern.matcher(email);
	        if(regMatcher.matches()) {
	        	res=true;
	        } 
			return res;

	    }

	    public boolean validateMobileNumber(String mobileNumber) {
	    	boolean res= false;
	        regexPattern = Pattern.compile("^\\+[0-9]{2,3}+-[0-9]{10}$");
	        regMatcher   = regexPattern.matcher(mobileNumber);
	        if(regMatcher.matches()) {
	        	res=true;
	        } 
	        return res;
	    }
	    
	    public boolean validateAge(String age)
	    {
	    	boolean result= false;
	    	if(age!=null&&age.length()<=2)
	    	{
	    		result=true;
	    	}
			return result;
			}
	    public boolean validateFname(String fname) throws IllegalArgumentException {
	    	boolean result= false;
			if (StringUtils.isNotBlank(fname) && StringUtils.isNumeric(fname)) {
				result=true;
			}
			return result;
		}
	    public boolean validateAddress(String currentAddress,String permanentAddress)
	    {
	    	boolean result= false;
	    	if(currentAddress!=null || permanentAddress!=null)
	    	{
	    		result=true;
	    	}
	    	return result;
	    }

}
