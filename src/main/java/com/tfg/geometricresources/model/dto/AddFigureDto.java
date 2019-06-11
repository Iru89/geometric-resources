package com.tfg.geometricresources.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.tfg.geometricresources.model.Figure;
import org.bson.types.ObjectId;

@JsonDeserialize(builder = AddFigureDto.AddFigureDtoBuilder.class)
@JsonIgnoreProperties
public class AddFigureDto {

    private Figure figure;
    private ObjectId userId;

    private AddFigureDto(Figure figure, ObjectId userId) {
        this.figure = figure;
        this.userId = userId;
    }

    public Figure getFigure() {
        return figure;
    }

    public ObjectId getUserId() {
        return userId;
    }

    @JsonPOJOBuilder
    public static class AddFigureDtoBuilder {

        private Figure figure;
        private ObjectId userId;

        private AddFigureDtoBuilder() {
        }

        public static AddFigureDtoBuilder builder(){
            return new AddFigureDtoBuilder();
        }

        public AddFigureDtoBuilder withFigure(Figure figure) {
            this.figure = figure;
            return this;
        }

        public AddFigureDtoBuilder withUserId(ObjectId userId) {
            this.userId = userId;
            return this;
        }

        public AddFigureDto build(){
            return new AddFigureDto(figure, userId);
        }
    }
}
