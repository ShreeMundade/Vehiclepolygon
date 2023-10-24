package com.renocrewsolutions.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renocrewsolutions.entity.Polygon;

public interface GeoPolygonRepository extends JpaRepository<Polygon, String> {
    // Custom queries can be added here
}
