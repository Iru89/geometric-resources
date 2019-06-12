package com.tfg.geometricresources.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.tfg.geometricresources.model.Figure;

@JsonDeserialize(builder = FigureDto.FigureDtoBuilder.class)
@JsonIgnoreProperties
public class FigureDto {

    private Figure figure;

    private FigureDto(Figure figure) {
        this.figure = figure;

    }

    public Figure getFigure() {
        return figure;
    }


    @JsonPOJOBuilder
    public static class FigureDtoBuilder {

        private Figure figure;


        private FigureDtoBuilder() {
        }

        public static FigureDtoBuilder builder(){
            return new FigureDtoBuilder();
        }

        public FigureDtoBuilder withFigure(Figure figure) {
            this.figure = figure;
            return this;
        }


        public FigureDto build(){
            return new FigureDto(figure);
        }
    }
}
