package com.tfg.geometricresources.repository;

import com.tfg.geometricresources.model.Figure;
import com.tfg.geometricresources.model.UserResources;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public class UserRepositoryImp {

    private MongoTemplate mongoTemplate;
    private UserRepository userRepository;

    public UserRepositoryImp(MongoTemplate mongoTemplate, UserRepository userRepository) {
        this.mongoTemplate = mongoTemplate;
        this.userRepository = userRepository;
    }

    public Optional<UserResources> addFigure(Figure figure, ObjectId userId) {
//        UserResources user = mongoTemplate.findOne(Query.query(Criteria.where("_id").is(userId)), UserResources.class);

        //PODEM FER EL MATEIX UTILITZANT EL REPOSITORY
        UserResources user = userRepository.findById(userId).orElse(new UserResources(userId, new ArrayList<Figure>()));

        if(user.getFigures().add(figure)){
            userRepository.save(user);
            return Optional.of(user);
        }
        return Optional.empty();
    }
}
