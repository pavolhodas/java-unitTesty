package com.example.demo.extra.security;

import org.springframework.stereotype.Service;

@Service
public interface UserDAO {
	void updateUser(User user);
}
