package com.renocrewsolutions.entity;

import java.util.List;

public class Polygon {
    private String _id;
    private String name;
    private String type;
    private List<GeoFeature> geoFeatures;
    private Geometry geometry;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<GeoFeature> getGeoFeatures() {
		return geoFeatures;
	}
	public void setGeoFeatures(List<GeoFeature> geoFeatures) {
		this.geoFeatures = geoFeatures;
	}
	public Geometry getGeometry() {
		return geometry;
	}
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}
	@Override
	public String toString() {
		return "Polygon [_id=" + _id + ", name=" + name + ", type=" + type + ", geoFeatures=" + geoFeatures
				+ ", geometry=" + geometry + "]";
	}
	public Polygon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Polygon(String _id, String name, String type, List<GeoFeature> geoFeatures, Geometry geometry) {
		super();
		this._id = _id;
		this.name = name;
		this.type = type;
		this.geoFeatures = geoFeatures;
		this.geometry = geometry;
	}
    
    
    // Getters and setters
}