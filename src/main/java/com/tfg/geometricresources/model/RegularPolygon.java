package com.tfg.geometricresources.model;

import org.bson.types.ObjectId;

public class RegularPolygon extends Figure{

    private String type = "REGULARPOLYGON";
    private Integer sides;
    private Integer radius;

    public RegularPolygon() {
    }

    public RegularPolygon(ObjectId id, String color) {
        super(id, color);
    }

    public RegularPolygon(ObjectId id, String color, Integer sides, Integer radius) {
        super(id, color);
        this.sides = sides;
        this.radius = radius;
    }

    public String getType() {
        return type;
    }

    public Integer getSides() {
        return sides;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setSides(Integer sides) {
        this.sides = sides;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }
}
