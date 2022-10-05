package com.example.demo.extra.security;

import org.springframework.stereotype.Service;

@Service
public interface SecurityService {
	String md5(String password);
}
