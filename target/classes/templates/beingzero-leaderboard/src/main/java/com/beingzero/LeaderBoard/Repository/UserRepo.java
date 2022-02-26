package com.beingzero.LeaderBoard.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beingzero.LeaderBoard.Model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

}
