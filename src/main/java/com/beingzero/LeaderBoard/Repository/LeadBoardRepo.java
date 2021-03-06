package com.beingzero.LeaderBoard.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beingzero.LeaderBoard.Model.LeadBoard;
import com.beingzero.LeaderBoard.Model.UserIDProblemIDKey;

@Repository
public interface LeadBoardRepo extends JpaRepository<LeadBoard, UserIDProblemIDKey>{

	//List<LeadBoard> findAllByProblemID(String problemID);

	List<LeadBoard> findAllByProblemIDOrderByScoreDesc(String problemID);


}
