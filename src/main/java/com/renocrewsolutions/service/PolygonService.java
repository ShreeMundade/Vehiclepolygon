package com.renocrewsolutions.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.renocrewsolutions.entity.Polygon;

@Service
public class PolygonService {
    private final String polygonDataUrl = "https://gist.github.com/codeofsumit/6540cdb245bd14c33b486b7981981b7b";

    private final RestTemplate restTemplate;

    public PolygonService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Polygon> getPolygons() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity(polygonDataUrl, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            // Parse the JSON response into a list of Polygon objects
            List<Polygon> polygons = parseGeoJson(response.getBody());
            return polygons;
        } else {
            throw new Exception("Failed to fetch polygons");
        }
    }

    private List<Polygon> parseGeoJson(String geoJson) {
		return null;
        // Implement the logic to parse GeoJSON data into a list of Polygon objects
        // You may use a library like Jackson to parse JSON or custom parsing logic.
    }
}
