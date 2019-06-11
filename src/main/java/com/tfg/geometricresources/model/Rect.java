package com.tfg.geometricresources.model;


import org.bson.types.ObjectId;

public class Rect extends Figure {

    private String type = "RECT";
    private Integer width;
    private Integer height;

    public Rect() {
    }

    public Rect(ObjectId id, String color){
        super(id, color);
    }

    public Rect(ObjectId id, String color, Integer width, Integer height) {
        super(id, color);
        this.width = width;
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

}
