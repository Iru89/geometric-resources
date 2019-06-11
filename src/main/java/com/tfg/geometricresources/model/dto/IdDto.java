package com.tfg.geometricresources.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.bson.types.ObjectId;

@JsonDeserialize(builder = IdDto.IdDtoBuilder.class)
public class IdDto {

    private final ObjectId id;

    private IdDto(ObjectId id) {
        this.id = id;
    }

    public String getId() {
        return id.toHexString();
    }

    @JsonPOJOBuilder
    public static class IdDtoBuilder{

        private ObjectId id;

        private IdDtoBuilder() {
        }

        public static IdDtoBuilder builder(){
            return new IdDtoBuilder();
        }

        public IdDtoBuilder withId(ObjectId id) {
            this.id = id;
            return this;
        }

        public IdDto build(){
            return new IdDto(id);
        }
    }
}
