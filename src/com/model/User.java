package com.model;

public class User {
	private int id; //id
	private String userName; //”√ªß√˚
	private String password; //√‹¬Î
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	
	public User(int id, String userName, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	

}
