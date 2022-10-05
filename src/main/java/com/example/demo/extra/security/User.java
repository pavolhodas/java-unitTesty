package com.example.demo.extra.security;

import org.springframework.stereotype.Service;

@Service
public interface User {
	String getPassword();

	void setPassword(String passwordMd5);
}
