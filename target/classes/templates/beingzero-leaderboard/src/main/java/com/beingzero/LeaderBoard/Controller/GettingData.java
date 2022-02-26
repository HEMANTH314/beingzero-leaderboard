package com.beingzero.LeaderBoard.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beingzero.LeaderBoard.Model.LeadBoard;
import com.beingzero.LeaderBoard.Model.ScoreBoard;
import com.beingzero.LeaderBoard.Model.User;
import com.beingzero.LeaderBoard.Model.UserIDProblemIDkey;
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
	
		//@ResponseBody
		@RequestMapping(value="/adddata", method = RequestMethod.POST, produces={"appication/json"})
		public void adddata1(@RequestBody ScoreBoard scoreBoard) {
			/* Save a new record into socre table */
			System.out.println(scoreBoard);
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
			
			//return new ResponseEntity<>(scoreBoard, HttpStatus.OK);
		}	

}
