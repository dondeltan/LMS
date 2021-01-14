package com.myapp.lms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class User{

	@Id
	@Column(name="id")
	private int id;
	
	 @Column(name = "userName")
	 private String userName;
	 @Column(name = "userPass")
	 private String userPass;
	 @Column(name = "enable")
	 private String enable;
	 
	 @ManyToOne
	 @JoinColumn(name="role_id")
	 private Role role;
	 
	 public User() {
		 
	 }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}
	
	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enable == null) ? 0 : enable.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPass == null) ? 0 : userPass.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (enable == null) {
			if (other.enable != null)
				return false;
		} else if (!enable.equals(other.enable))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPass == null) {
			if (other.userPass != null)
				return false;
		} else if (!userPass.equals(other.userPass))
			return false;
		return true;
	}

	public User(String userName, String userPass, String enable) {
		super();
		this.userName = userName;
		this.userPass = userPass;
		this.enable = enable;
	}
	 
	 
	 
}
