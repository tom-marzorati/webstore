package com.accenture.dao;

import com.accenture.model.User;

public interface UserDaoInterface {
	
	
	public boolean addUser (User user);
	public User getById(String username);
	public boolean updateUser(User user);
	public boolean deleteUser (String username);
	public boolean checkUser (String username);
	

}
