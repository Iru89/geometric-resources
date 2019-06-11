package com.tfg.geometricresources.model;

import org.bson.types.ObjectId;

import java.util.List;

//@JsonDeserialize(builder = UserResources.UserResourcesBuilder.class)
public class UserResources {
    private ObjectId id;
    private List<Figure> figures;

    public UserResources() {
    }

    public UserResources(ObjectId id, List<Figure> figures) {
        this.id = id;
        this.figures = figures;
    }

    public ObjectId getId() {
        return id;
    }

    public List<Figure> getFigures() {
        return figures;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setFigures(List<Figure> figures) {
        this.figures = figures;
    }

//    @JsonPOJOBuilder
//    public static class UserResourcesBuilder{
//        private ObjectId id;
//        private List<Figure> figures;
//
//        private UserResourcesBuilder(){
//        }
//
//        public static UserResourcesBuilder builder(){
//            return new UserResourcesBuilder();
//        }
//
//        public UserResourcesBuilder withId(ObjectId id){
//            this.id = id;
//            return this;
//        }
//
//        public UserResourcesBuilder withFigures(List<Figure> figures) {
//            this.figures = figures;
//            return this;
//        }
//
//        public UserResources build(){
//            return new UserResources(id, figures);
//        }
//    }
}
