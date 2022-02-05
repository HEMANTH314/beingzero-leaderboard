package com.beingzero.LeaderBoard.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.beingzero.LeaderBoard.Model.LeadBoard;
import com.beingzero.LeaderBoard.Model.ScoreBoard;
import com.beingzero.LeaderBoard.Model.User;
import com.beingzero.LeaderBoard.Model.UserIDProblemIDkey;
import com.beingzero.LeaderBoard.Repository.LeadBoardRepo;
import com.beingzero.LeaderBoard.Repository.ScoreBoardRepo;
import com.beingzero.LeaderBoard.Repository.UserRepo;



@Controller
public class MainContorller {
	@Autowired
	ScoreBoardRepo scoreBoardRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	LeadBoardRepo leadBoardRepo;
	
	@GetMapping("/inputdata")
	public String updatedata(Model model) {
		ScoreBoard scoreBoard = new ScoreBoard();
		model.addAttribute("scoreBoard", scoreBoard);
		return "inputdata";
	}
	@PostMapping("/inputdata")
	public String adddata1(@ModelAttribute("scoreBoard")ScoreBoard scoreBoard) {
		/* Save a new record into socre table */
		scoreBoardRepo.save(scoreBoard);
		//System.out.println(scoreBoard);
		
		/* Updating user table */
		User user = new User(scoreBoard.getUserID(),scoreBoard.getUserName());
		//System.out.println(user);
		userRepo.save(user);
		
		/* Updating lead table */
		UserIDProblemIDkey userIDProblemIDkey = new UserIDProblemIDkey(scoreBoard.getUserID(),scoreBoard.getProblemID());
		LeadBoard tmp = leadBoardRepo.findById(userIDProblemIDkey).orElse(null);
		if(tmp == null) {
			LeadBoard leadBoard = new LeadBoard(scoreBoard.getUserID(), scoreBoard.getUserName(), scoreBoard.getSubmisionID(),
					scoreBoard.getProblemID(), scoreBoard.isCompletionResult(), scoreBoard.isExecutionResult(), 
					scoreBoard.getScore(), scoreBoard.getSubmissionDate(), scoreBoard.getLanguage());
			leadBoardRepo.save(leadBoard);
		}else if(tmp.getScore() < scoreBoard.getScore()){
			tmp.setSubmisionID(scoreBoard.getSubmisionID());
			tmp.setCompletionResult(scoreBoard.isCompletionResult());
			tmp.setExecutionResult(scoreBoard.isExecutionResult());
			tmp.setLanguage(scoreBoard.getLanguage());
			tmp.setSubmissionDate(scoreBoard.getSubmissionDate());
			tmp.setScore(scoreBoard.getScore());
			leadBoardRepo.save(tmp);
		}
		return "inputdata";
	}
	
	@GetMapping("leaderboard/{problemID}")
	public String test1(Model model, @PathVariable("problemID") String problemID) {
		List<LeadBoard>  RankTable = leadBoardRepo.findAllByProblemIDOrderByScoreDesc(problemID);
		//System.out.println(RankTable);
		model.addAttribute("RankTable", RankTable);
		model.addAttribute("problemID",problemID);
		return "leaderboard";
	}
	
}
/***
 * 
 *
try {
	User user = new User(scoreBoard.getUserID(),scoreBoard.getUserName());
	System.out.println(user);
	userRepo.save(user);
}catch(Exception e){
	System.out.println("Already Existed!!!");
}
try {
	LeadBoard leadBoard = new LeadBoard(scoreBoard.getUserID(), scoreBoard.getUserName(), scoreBoard.getSubmisionID(),
			scoreBoard.getProblemID(), scoreBoard.isCompletionResult(), scoreBoard.isExecutionResult(), 
			scoreBoard.getScore(), scoreBoard.getSubmissionDate(), scoreBoard.getLanguage());
	System.out.println(leadBoard);
	
	leadBoardRepo.save(leadBoard);
}catch(Exception e) {
	System.out.println("Already Existed!!!");
}
*
*
***/

