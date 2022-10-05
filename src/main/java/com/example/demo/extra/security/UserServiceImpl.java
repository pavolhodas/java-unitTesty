package com.example.demo.extra.security;


import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

	private UserDAO userDAO;
	private SecurityService securityService;

	public void assignPassword(User user) {
		String passwordMd5 = securityService.md5(user.getPassword());
		user.setPassword(passwordMd5);
		userDAO.updateUser(user);
	}
}
