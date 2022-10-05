package com.example.demo.extra;

import org.springframework.stereotype.Service;

@Service
public class TestService
{
    public boolean isPalindrome(String inputString) {
        if (inputString.length() <= 1)
        {
            return true;
        } else {
            char firstChar = inputString.charAt(0);
            char lastChar = inputString.charAt(inputString.length() - 1);
            String mid = inputString.substring(1, inputString.length() - 1);
            return (firstChar == lastChar) && isPalindrome(mid);
        }
    }
}
