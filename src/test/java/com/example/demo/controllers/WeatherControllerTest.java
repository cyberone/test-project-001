package com.example.demo.controllers;

import com.example.demo.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WeatherControllerTest {
    @Mock
    WeatherService  weatherService;

    @InjectMocks
    WeatherController weatherController;
    @Test
    public void test() {
        weatherController.getWeather();
    }
}
