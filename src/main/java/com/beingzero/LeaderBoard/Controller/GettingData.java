package com.beingzero.LeaderBoard.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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


@RestController
public class GettingData {
	@Autowired
	ScoreBoardRepo scoreBoardRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	LeadBoardRepo leadBoardRepo;
	
	@Autowired 
	ContestLeaderBoardRepo contestLeaderBoardRepo;
	
		//@ResponseBody
		@RequestMapping(value = "/adddata", method = RequestMethod.POST, produces = { "appication/json" })
		public void adddata1(@RequestBody ScoreBoard scoreBoard) {
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
		}

}
