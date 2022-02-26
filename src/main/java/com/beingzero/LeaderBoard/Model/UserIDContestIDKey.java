package com.beingzero.LeaderBoard.Model;

import java.io.Serializable;


//import lombok.NoArgsConstructor;

//@NoArgsConstructor
public class UserIDContestIDKey implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userID;
	private String contestID;
	
	public UserIDContestIDKey() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public UserIDContestIDKey(String userID, String contestID) {
		super();
		this.userID = userID;
		this.contestID = contestID;
	}
	
	@Override
	public String toString() {
		return "UserIDContestIdProblemIDkey [userID=" + userID + ", contestID=" + contestID + "]";
	}


	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getContestID() {
		return contestID;
	}

	public void setContestID(String contestID) {
		this.contestID = contestID;
	}

}
