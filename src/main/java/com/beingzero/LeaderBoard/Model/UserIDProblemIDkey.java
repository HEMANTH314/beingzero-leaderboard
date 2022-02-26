package com.beingzero.LeaderBoard.Model;

import java.io.Serializable;


//import lombok.NoArgsConstructor;

//@NoArgsConstructor
public class UserIDProblemIDKey implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userID;
	private String problemID;
	
	
	public UserIDProblemIDKey() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public UserIDProblemIDKey(String userID, String problemID) {
		super();
		this.userID = userID;
		this.problemID = problemID;
	}
	

	@Override
	public String toString() {
		return "UserIDContestIdProblemIDKey [userID=" + userID + ", problemID=" + problemID + "]";
	}

	/*
	@Override
	public int hashCode() {
		return Objects.hash(problemID, userID);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserIDProblemIDkey other = (UserIDProblemIDkey) obj;
		return Objects.equals(problemID, other.problemID) && Objects.equals(userID, other.userID);
	}

*/
	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getProblemID() {
		return problemID;
	}


	public void setProblemID(String problemID) {
		this.problemID = problemID;
	}

}
