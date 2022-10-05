package com.example.demo.extra.fridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FridgeServiceTest
{
    @InjectMocks
    private FridgeService fridgeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_add_item_to_fridge() {

    }

    @Test
    public void should_not_have_item_after_taken_out() {

    }
}
