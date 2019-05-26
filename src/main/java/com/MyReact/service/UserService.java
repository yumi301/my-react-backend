package com.MyReact.service;

import com.MyReact.domain.User;

public interface UserService {
	
	public User getUser(int id);
	
	public User getUserbyName(String userName);
	
	public User getUserbyEmail(String userEmail);
	
	public User addUser(String userName, String userEmail, String password);
	
	public boolean is_eamil_legal(String userEmail);

}
