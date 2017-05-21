package com.EWServlet.servlets;

public class LoginBean {
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isValidAdmin() {
		boolean cond1="admin".equalsIgnoreCase(userName) && "admin".equalsIgnoreCase(password);
	    return cond1 ;
	}
	public boolean isValidUser() {
		boolean cond2="user".equalsIgnoreCase(userName) && "user".equalsIgnoreCase(password);
	      return cond2;
	}

}
