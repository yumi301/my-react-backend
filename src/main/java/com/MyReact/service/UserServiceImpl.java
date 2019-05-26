package com.MyReact.service;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyReact.dao.UserDAO;
import com.MyReact.domain.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public User getUser(int id) {
		// TODO Auto-generated method stub
		User user = userDAO.getUser(id);
		return user;
	}

	@Override
	@Transactional
	public User getUserbyName(String userName) {
		// TODO Auto-generated method stub
		User user = userDAO.getUserbyName(userName);
		return user;
	}

	@Override
	@Transactional
	public User getUserbyEmail(String userEmail) {
		// TODO Auto-generated method stub
		User user = userDAO.getUserbyEmail(userEmail);
		return user;
	}

	@Override
	public User addUser(String userName, String userEmail, String password) {
		// TODO Auto-generated method stub
		User user = new User();
        user.setUserName(userName);
        user.setUserEmail(userEmail);
        user.setPassword(password);
        user.setUserImage(null);
        user.setCreatedTime(new Date());
        user.setLastLoginTime(new Date());
		userDAO.addUser(user);
		return user;
	}

	@Override
	public boolean is_eamil_legal(String userEmail) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
		Matcher m = p.matcher(userEmail);
		return m.matches();
	}
	
	
	
	

}