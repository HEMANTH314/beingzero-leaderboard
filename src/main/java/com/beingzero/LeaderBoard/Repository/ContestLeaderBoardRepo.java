package com.beingzero.LeaderBoard.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beingzero.LeaderBoard.Model.ContestLeaderBoard;
import com.beingzero.LeaderBoard.Model.UserIDContestIDKey;

public interface ContestLeaderBoardRepo extends JpaRepository<ContestLeaderBoard, UserIDContestIDKey>{
	
	List<ContestLeaderBoard> findAllByContestIDOrderByScoreDesc(String contestID);
	
}
