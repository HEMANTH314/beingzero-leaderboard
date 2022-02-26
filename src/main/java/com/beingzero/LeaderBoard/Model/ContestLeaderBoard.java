package com.beingzero.LeaderBoard.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "ContestLeadBoard")
@IdClass(UserIDContestIDKey.class)
public class ContestLeaderBoard {

	@Id 
	private String userID;
	
	@Id
	private String contestID;
	
	private String userName;
	
	@Column(columnDefinition = "int default 0")
	private int score;
	
	@Column(columnDefinition = "int default 0")
	private int solvedProbelems;

	public ContestLeaderBoard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContestLeaderBoard(String userID, String contestID, String userName, int score, int solvedProbelems) {
		super();
		this.userID = userID;
		this.contestID = contestID;
		this.userName = userName;
		this.score = score;
		this.solvedProbelems = solvedProbelems;
	}

	@Override
	public String toString() {
		return "ContestLeaderBoard [userID=" + userID + ", contestID=" + contestID + ", userName=" + userName
				+ ", score=" + score + ", solvedProbelems=" + solvedProbelems + "]";
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getSolvedProbelems() {
		return solvedProbelems;
	}

	public void setSolvedProbelems(int solvedProbelems) {
		this.solvedProbelems = solvedProbelems;
	}	
	
}
