package com.tfg.geometricresources.model;

import org.bson.types.ObjectId;

public class Ellipse extends Figure{

    private String type = "ELLIPSE";
    private Integer radiusX;
    private Integer radiusY;

    public Ellipse() {
    }

    public Ellipse(ObjectId id, String color) {
        super(id, color);
    }

    public Ellipse(ObjectId id, String color, Integer radiusX, Integer radiusY) {
        super(id, color);
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    public String getType() {
        return type;
    }

    public Integer getRadiusX() {
        return radiusX;
    }

    public Integer getRadiusY() {
        return radiusY;
    }

    public void setRadiusX(Integer radiusX) {
        this.radiusX = radiusX;
    }

    public void setRadiusY(Integer radiusY) {
        this.radiusY = radiusY;
    }
}
