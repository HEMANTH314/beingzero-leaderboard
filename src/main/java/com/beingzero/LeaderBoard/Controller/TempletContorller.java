package com.beingzero.LeaderBoard.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.beingzero.LeaderBoard.Model.ContestLeaderBoard;
import com.beingzero.LeaderBoard.Model.LeadBoard;
import com.beingzero.LeaderBoard.Model.ScoreBoard;
import com.beingzero.LeaderBoard.Model.User;
import com.beingzero.LeaderBoard.Model.UserIDContestIDKey;
import com.beingzero.LeaderBoard.Model.UserIDProblemIDKey;
import com.beingzero.LeaderBoard.Repository.ContestLeaderBoardRepo;
import com.beingzero.LeaderBoard.Repository.LeadBoardRepo;
import com.beingzero.LeaderBoard.Repository.ScoreBoardRepo;
import com.beingzero.LeaderBoard.Repository.UserRepo;

@Controller
public class TempletContorller {
	@Autowired
	ScoreBoardRepo scoreBoardRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	LeadBoardRepo leadBoardRepo;

	@Autowired
	ContestLeaderBoardRepo contestLeaderBoardRepo;

	@GetMapping("/inputdata")
	public String inputdata(Model model) {
		ScoreBoard scoreBoard = new ScoreBoard();
		model.addAttribute("scoreBoard", scoreBoard);
		return "inputdata";
	}

	/* Adding data using html page */
	@PostMapping("/inputdata")
	public String adddata(@ModelAttribute("scoreBoard") ScoreBoard scoreBoard) {
		/* Getting the scoreBoard data */
		String submisionID = scoreBoard.getSubmisionID();
		String userID = scoreBoard.getUserID();
		String userName = scoreBoard.getUserName();
		String contestID = scoreBoard.getContestID();			
		String problemID = scoreBoard.getProblemID();			
		boolean completionResult = scoreBoard.isCompletionResult();			
		boolean executionResult = scoreBoard.isExecutionResult();			
		int score = scoreBoard.getScore();			
		String submissionDate = scoreBoard.getSubmissionDate();			
		String language = scoreBoard.getLanguage();
		
		/* Save a new record into socreBoard table */
		//System.out.println(scoreBoard);
		scoreBoardRepo.save(scoreBoard);
		// System.out.println(scoreBoard);

		/* Updating users table */
		User user = new User(userID, userName);
		// System.out.println(user);
		userRepo.save(user);

		/* Updating leaderBoard table and contestleaderboard table*/
		UserIDProblemIDKey userIDProblemIDKey = new UserIDProblemIDKey(userID, problemID);
		LeadBoard tmp = leadBoardRepo.findById(userIDProblemIDKey).orElse(null);
		
		UserIDContestIDKey userIDContestIDKey = new UserIDContestIDKey(userID, contestID);
		ContestLeaderBoard tmp1 = contestLeaderBoardRepo.findById(userIDContestIDKey).orElse(null);
		if (tmp == null && tmp1 == null) {
			LeadBoard leadBoard = new LeadBoard(userID, userName, submisionID, problemID, completionResult,
					executionResult, score, submissionDate,	language);
			leadBoardRepo.save(leadBoard);
			
			int solvedProbelems = (completionResult)?1:0;
			
			ContestLeaderBoard contestLeaderBoard = new ContestLeaderBoard(userID, contestID, 
					userName, score, solvedProbelems);

			contestLeaderBoardRepo.save(contestLeaderBoard);
			
		} else if (tmp==null && tmp1!=null) {
			LeadBoard leadBoard = new LeadBoard(userID, userName, submisionID, problemID, completionResult,
					executionResult, score, submissionDate,	language);
			leadBoardRepo.save(leadBoard);
			
			int solvedProbelems = (completionResult)?1:0;
			
			tmp1.setSolvedProbelems(tmp1.getSolvedProbelems() + solvedProbelems);
			tmp1.setScore(tmp1.getScore() + score);
			
			contestLeaderBoardRepo.save(tmp1);
			
		}else if (tmp.getScore() < score) {
			
			int solvedProbelems = (scoreBoard.isCompletionResult() && !tmp.isCompletionResult())?1:0;
			tmp1.setSolvedProbelems(tmp1.getSolvedProbelems() + solvedProbelems);
			
			int newScore = score - tmp.getScore();
			tmp1.setScore(tmp1.getScore() + newScore);
			
			contestLeaderBoardRepo.save(tmp1);
			
			tmp.setSubmisionID(submisionID);
			tmp.setCompletionResult(completionResult);
			tmp.setExecutionResult(executionResult);
			tmp.setLanguage(language);
			tmp.setSubmissionDate(submissionDate);
			tmp.setScore(score);
			
			leadBoardRepo.save(tmp);
		}

		// return new ResponseEntity<>(scoreBoard, HttpStatus.OK);
		return "inputdata";
	}

	@GetMapping("leaderboard/{problemID}")
	public String test1(Model model, @PathVariable("problemID") String problemID) {
		List<LeadBoard> RankTable = leadBoardRepo.findAllByProblemIDOrderByScoreDesc(problemID);
		// System.out.println(RankTable);
		model.addAttribute("RankTable", RankTable);
		model.addAttribute("problemID", problemID);
		return "leaderboard";
	}

	@GetMapping("contestleaderboard/{contestID}")
	public String test2(Model model, @PathVariable("contestID") String contestID) {
		List<ContestLeaderBoard> RankTable = contestLeaderBoardRepo.findAllByContestIDOrderByScoreDesc(contestID);
		// System.out.println(RankTable);
		model.addAttribute("RankTable", RankTable);
		model.addAttribute("contestID", contestID);
		return "leaderboard1";
	}

}

/***
 * 
 *
 * try { User user = new User(scoreBoard.getUserID(),scoreBoard.getUserName());
 * System.out.println(user); userRepo.save(user); }catch(Exception e){
 * System.out.println("Already Existed!!!"); } try { LeadBoard leadBoard = new
 * LeadBoard(scoreBoard.getUserID(), scoreBoard.getUserName(),
 * scoreBoard.getSubmisionID(), scoreBoard.getProblemID(),
 * scoreBoard.isCompletionResult(), scoreBoard.isExecutionResult(),
 * scoreBoard.getScore(), scoreBoard.getSubmissionDate(),
 * scoreBoard.getLanguage()); System.out.println(leadBoard);
 * 
 * leadBoardRepo.save(leadBoard); }catch(Exception e) {
 * System.out.println("Already Existed!!!"); }
 *
 *
 ***/
