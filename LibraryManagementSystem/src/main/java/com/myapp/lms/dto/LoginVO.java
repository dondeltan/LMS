package com.myapp.lms.dto;

public class LoginVO implements Cloneable{

	private String authenticatedString;
	
	public LoginVO() {
		
	}

	public String getAuthenticatedString() {
		return authenticatedString;
	}

	public void setAuthenticatedString(String authenticatedString) {
		this.authenticatedString = authenticatedString;
	}
	
	
}
