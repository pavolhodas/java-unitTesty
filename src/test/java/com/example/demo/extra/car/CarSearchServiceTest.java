package com.example.demo.extra.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.awt.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;

public class CarSearchServiceTest
{
    @InjectMocks
    private CarSearchService carSearchService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_return_no_sport_cars_when_only_one_non_sport_car_was_added() {

    }

    @Test
    public void should_return_two_sports_cars_which_were_added() {

    }

}
