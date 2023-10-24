package com.renocrewsolutions.service;

import java.util.List;
import com.fasterxml.jackson.databind.JsonNode;
import com.renocrewsolutions.entity.Polygon;

public interface GeoPolygonService {
    List<Polygon> getAllPolygons();
    JsonNode getPolygonById(String id);
    // Other service methods
}
