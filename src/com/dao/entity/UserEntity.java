package com.dao.entity;
import java.sql.Timestamp;

public class UserEntity {
	private int uID;
	private String userName;
	private String password;
	private String name;
	private String email;
	private String salutation;
	private Timestamp timeStamp;
	private String role;
	
	
	public UserEntity(int uID, String userName, String password, String name, String email, String salutation,
			Timestamp timeStamp, String role) {
		super();
		this.uID = uID;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.email = email;
		this.salutation = salutation;
		this.timeStamp = timeStamp;
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "UserEntity [uID=" + uID + ", userName=" + userName + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", salutation=" + salutation + ", timeStamp=" + timeStamp + ", role=" + role
				+ "]";
	}

	
	
	
}
