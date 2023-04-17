package com.example.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;
    public JsonNode getWeather() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("X-Yandex-API-Key", apiKey);
        ResponseEntity<String> body = restTemplate
            .exchange("https://api.weather.yandex.ru/v2/forecast?limit=1", HttpMethod.GET, new HttpEntity<>(null, headers), String.class);
        try {
            return new ObjectMapper().readTree(body.getBody());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
