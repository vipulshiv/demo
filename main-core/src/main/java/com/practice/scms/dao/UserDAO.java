package com.practice.scms.dao;

import java.util.List;

import com.practice.scms.model.LoginRqst;
import com.practice.scms.model.User;

public interface UserDAO {

	public void save(User user);
	
	public User checkUser(User user1);
}
