package com.example.demo.extra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringUtilsServiceTest
{
    @InjectMocks
    private StringUtilsService stringUtilsService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test()
    public void stringShouldBeReversed(){
        assertEquals(stringUtilsService.reverse("string"), "gnirts");
    }

    @Test()
    public void shouldWorkForEmptyString(){
        assertEquals(stringUtilsService.reverse(""), "");
    }
}
