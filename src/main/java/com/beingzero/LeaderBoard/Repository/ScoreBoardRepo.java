package com.beingzero.LeaderBoard.Repository;

import org.springframework.stereotype.Repository;

import com.beingzero.LeaderBoard.Model.ScoreBoard;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ScoreBoardRepo extends JpaRepository<ScoreBoard, Long>{

}
