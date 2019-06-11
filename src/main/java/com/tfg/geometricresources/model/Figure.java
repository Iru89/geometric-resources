package com.tfg.geometricresources.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @Type(value = Rect.class, name = "RECT"),
        @Type(value = Circle.class, name = "CIRCLE"),
        @Type(value = RegularPolygon.class, name = "REGULARPOLYGON"),
        @Type(value = Ellipse.class, name = "ELLIPSE"),
})
public abstract class Figure {

    @Id
    private ObjectId id;
    private String color;

    public Figure() {
    }

    public Figure(ObjectId id, String color) {
        this.id = id;
        this.color = color;
    }

    public String getId() {
        return id.toHexString();
    }

    public String getColor() {
        return color;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
