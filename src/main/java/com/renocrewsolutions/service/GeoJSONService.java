package com.renocrewsolutions.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.renocrewsolutions.entity.Polygon;

import Exceptions.CustomException;

@Service
public class GeoJSONService {
    private final String geoJSONUrl = "https://gist.githubusercontent.com/codeofsumit/6540cdb245bd14c33b486b7981981b7b/raw/73ebda86c32923e203b2a8e61615da3e5f1695a2/polygons.json";

    private final RestTemplate restTemplate;

    public GeoJSONService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Polygon> fetchGeoJSONData() {
        ResponseEntity<String> response = restTemplate.getForEntity(geoJSONUrl, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            // Parse the JSON response into a list of Polygon objects
            List<Polygon> polygons = parseGeoJSON(response.getBody());
            return polygons;
        } else {
            throw new CustomException("Failed to fetch GeoJSON data");
        }
    }

    private List<Polygon> parseGeoJSON(String geoJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            return objectMapper.readValue(geoJson, new TypeReference<List<Polygon>>() {});
        } catch (JsonProcessingException e) {
            throw new CustomException("Failed to parse GeoJSON data");
        }
    }
}
