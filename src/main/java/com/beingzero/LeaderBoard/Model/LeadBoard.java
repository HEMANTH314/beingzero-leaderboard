package com.beingzero.LeaderBoard.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "LeadBoard")
@IdClass(UserIDProblemIDkey.class)
public class LeadBoard {
	
	@Id
	private String userID;
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private long ID;
	@Id
	private String problemID;
	
	private String submisionID;
	
	private String userName;
	
	private boolean completionResult;
	
	private boolean executionResult;
	
	private int score;
	
	private String submissionDate;
	
	private String language;


	@Override
	public String toString() {
		return "LeadBoard [userID=" + userID + ", userName=" + userName + ", submisionID=" + submisionID
				+ ", problemID=" + problemID + ", completionResult=" + completionResult + ", executionResult="
				+ executionResult + ", score=" + score + ", submissionDate=" + submissionDate + ", language=" + language
				+ "]";
	}

	public LeadBoard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LeadBoard(String userID, String userName, String submisionID, String problemID, boolean completionResult,
			boolean executionResult, int score, String submissionDate, String language) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.submisionID = submisionID;
		this.problemID = problemID;
		this.completionResult = completionResult;
		this.executionResult = executionResult;
		this.score = score;
		this.submissionDate = submissionDate;
		this.language = language;
	}

/*
	@Override
	public String toString() {
		return "LeadBoard [ID=" + ID + ", submisionID=" + submisionID + ", userID=" + userID + ", userName=" + userName
				+ ", problemID=" + problemID + ", completionResult=" + completionResult + ", executionResult="
				+ executionResult + ", score=" + score + ", submissionDate=" + submissionDate + ", language=" + language
				+ "]";
	}
	
	public LeadBoard(long iD, String submisionID, String userID, String userName, String problemID,
			boolean completionResult, boolean executionResult, int score, String submissionDate, String language) {
		super();
		ID = iD;
		this.submisionID = submisionID;
		this.userID = userID;
		this.userName = userName;
		this.problemID = problemID;
		this.completionResult = completionResult;
		this.executionResult = executionResult;
		this.score = score;
		this.submissionDate = submissionDate;
		this.language = language;
	}


	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}
*/
	public String getSubmisionID() {
		return submisionID;
	}

	public void setSubmisionID(String submisionID) {
		this.submisionID = submisionID;
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

	public String getProblemID() {
		return problemID;
	}

	public void setProblemID(String problemID) {
		this.problemID = problemID;
	}

	public boolean isCompletionResult() {
		return completionResult;
	}

	public void setCompletionResult(boolean completionResult) {
		this.completionResult = completionResult;
	}

	public boolean isExecutionResult() {
		return executionResult;
	}

	public void setExecutionResult(boolean executionResult) {
		this.executionResult = executionResult;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(String submissionDate) {
		this.submissionDate = submissionDate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	
}