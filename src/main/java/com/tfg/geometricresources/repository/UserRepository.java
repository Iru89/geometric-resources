package com.tfg.geometricresources.repository;

import com.tfg.geometricresources.model.UserResources;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserResources, String> {
    Optional<UserResources> findById(ObjectId id);
}
