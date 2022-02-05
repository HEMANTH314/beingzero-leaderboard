package com.beingzero.LeaderBoard.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ScoreBoard")
public class ScoreBoard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;
	
	private String submisionID;
	
	private String userID;
	
	private String userName;
	
	private String problemID;
	
	private boolean completionResult;
	
	private boolean executionResult;
	
	private int score;
	
	private String submissionDate;
	
	private String language;

	
	@Override
	public String toString() {
		return "ScoreBoard [ID=" + ID + ", submisionID=" + submisionID + ", userID=" + userID + ", userName=" + userName
				+ ", problemID=" + problemID + ", completionResult=" + completionResult + ", executionResult="
				+ executionResult + ", score=" + score + ", submissionDate=" + submissionDate + ", language=" + language
				+ "]";
	}

	public ScoreBoard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScoreBoard(long iD, String submisionID, String userID, String userName, String problemID,
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