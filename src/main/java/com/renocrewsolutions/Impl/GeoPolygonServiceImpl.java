package com.renocrewsolutions.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.JsonNode;
import com.renocrewsolutions.entity.Polygon;
import com.renocrewsolutions.repo.GeoPolygonRepository;
import com.renocrewsolutions.service.GeoPolygonService;

import java.util.List;

@Service
public class GeoPolygonServiceImpl implements GeoPolygonService {
    private final GeoPolygonRepository geoPolygonRepository;

    @Autowired
    public GeoPolygonServiceImpl(GeoPolygonRepository geoPolygonRepository) {
        this.geoPolygonRepository = geoPolygonRepository;
    }

    @Override
    public List<Polygon> getAllPolygons() {
        return geoPolygonRepository.findAll();
    }

    @Override
    public JsonNode getPolygonById(String id) {
        // Implement logic to fetch and return a specific polygon by ID
        return null;
    }
    // Other service methods
}
