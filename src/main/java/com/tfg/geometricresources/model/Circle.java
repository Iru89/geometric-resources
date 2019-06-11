package com.tfg.geometricresources.model;

import org.bson.types.ObjectId;


public class Circle extends Figure {

    private String type = "CIRCLE";
    private Integer radius;

    public Circle() {
    }

    public Circle(ObjectId id, String color) {
        super(id, color);
    }

    public Circle(ObjectId id, String color, Integer radius) {
        super(id, color);
        this.radius = radius;
    }

    public String getType() {
        return type;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

}
