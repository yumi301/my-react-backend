package com.MyReact.controller;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.MyReact.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.MyReact.domain.User;
import com.MyReact.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class UserController {

	@Autowired
	private UserService userService;

	// get user by id
	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(@PathVariable("id") int id) throws Exception {
		System.out.println("Fetching User with id " + id);
		User user = userService.getUser(id);
		if (user == null) {
			System.out.println("User with id " + id + " not found");
			throw new UserNotFoundException("User with id " + id + " not found");
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserbyName(@RequestBody User inputUser, HttpServletResponse response)
			throws Exception {

		String userName = inputUser.getUserName();
		String password = inputUser.getPassword();

		System.out.println("Fetching User with name " + userName);

		User user = userService.getUserbyName(userName);

		if (user == null) {
			System.out.println("User with name " + userName + " not found");
			user = userService.getUserbyEmail(userName);// check userEmail
			if (user == null) {
				System.out.println("no userName or userEmail!");

				throw new UserNotFoundException("no userName or userEmail");
			}
		}

		if (password.equals(user.getPassword())) {

//			response.addHeader("Authorization", "Bearer " + token);
////			// preflight
			response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, HEAD");
			response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
////			response.addHeader("Access-Control-Allow-Credentials", "false");

			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		System.out.println("password error!");
		throw new UserNotFoundException("password error");

	}
	
	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> Register(@RequestBody User inputUser) throws Exception {

		String userName = inputUser.getUserName();
		String userEmail = inputUser.getUserEmail();
		String password = inputUser.getPassword();

		System.out.println("Fetching User with name" + userName);
		User userinDB = userService.getUserbyName(userName);
		if (userinDB != null) {
			System.out.println("User with name " + userName + " exists");
			throw new UserNotFoundException("User with name " + userName + " exists");
		}
		userinDB = userService.getUserbyEmail(userEmail);
		if (userinDB != null) {
			System.out.println("User with email " + userName + " exists");
			throw new UserNotFoundException("User with email " + userName + " exists");
		}
		if (userService.is_eamil_legal(userEmail) == false) {
			System.out.println("userEmail format error!");
			throw new UserNotFoundException("userEmail format error!");
		}
		User user = userService.addUser(userName, userEmail, password);
		System.out.println("register user!");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
