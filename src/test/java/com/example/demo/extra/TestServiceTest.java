package com.example.demo.extra;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestServiceTest
{
    
    @InjectMocks
    private TestService testService;
    
    @Test
    public void whenEmptyString_thenAccept() {
        MockitoAnnotations.openMocks(this);
        assertTrue(testService.isPalindrome(""));
    }

    @Test
    public void whenNotEmptyString_thenAccept() {
        MockitoAnnotations.openMocks(this);
        assertTrue(testService.isPalindrome("radar"));
    }
}
