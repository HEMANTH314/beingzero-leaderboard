package com.beingzero.LeaderBoard.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String userID;
	
	private String userName;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userID, String userName) {
		super();
		this.userID = userID;
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + "]";
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}