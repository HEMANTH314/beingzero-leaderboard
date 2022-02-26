package com.beingzero.LeaderBoard.Model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ScoreBoard")
public class ScoreBoard {
	

	@Id
	//@GeneratedValue(strategy =GenerationType.AUTO)
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
		return "ScoreBoard [submisionID=" + submisionID + ", userID=" + userID + ", userName=" + userName
				+ ", problemID=" + problemID + ", completionResult=" + completionResult + ", executionResult="
				+ executionResult + ", score=" + score + ", submissionDate=" + submissionDate + ", language=" + language
				+ "]";
	}

	public ScoreBoard() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ScoreBoard(String submisionID, String userID, String userName, String problemID,
			boolean completionResult, boolean executionResult, int score, String submissionDate, String language) {
		super();
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

	@Override
	public int hashCode() {
		return Objects.hash(completionResult, executionResult, language, problemID, score, submisionID, submissionDate,
				userID, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScoreBoard other = (ScoreBoard) obj;
		return completionResult == other.completionResult && executionResult == other.executionResult
				&& Objects.equals(language, other.language) && Objects.equals(problemID, other.problemID)
				&& score == other.score && Objects.equals(submisionID, other.submisionID)
				&& Objects.equals(submissionDate, other.submissionDate) && Objects.equals(userID, other.userID)
				&& Objects.equals(userName, other.userName);
	}

	

}