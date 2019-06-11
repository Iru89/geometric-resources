package com.tfg.geometricresources.service;

import com.tfg.geometricresources.exception.IdException;
import com.tfg.geometricresources.model.*;
import com.tfg.geometricresources.model.Figure;
import com.tfg.geometricresources.model.dto.IdDto;
import com.tfg.geometricresources.model.dto.IdDto.IdDtoBuilder;
import com.tfg.geometricresources.repository.UserRepository;
import com.tfg.geometricresources.repository.UserRepositoryImp;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FigureService {

    private UserRepositoryImp userRepositoryImp;
    private UserRepository userRepository;

    public FigureService(UserRepositoryImp userRepositoryImp, UserRepository userRepository) {
        this.userRepositoryImp = userRepositoryImp;
        this.userRepository = userRepository;
    }

    public ResponseEntity add(Figure figure, ObjectId userId){

        figure.setId(new ObjectId());

        Optional<UserResources> oUser = userRepositoryImp.addFigure(figure, userId);
        int lastFigure = oUser.get().getFigures().size()-1;
        figure = oUser.get().getFigures().get(lastFigure);

        return ResponseEntity.ok().body(figure);
    }


    public ResponseEntity getList(ObjectId userId) {

        try{
            UserResources user = userRepository.findById(userId).orElseThrow(
                    () -> new IdException("UserResources not found with id : " + userId)
            );

            return ResponseEntity.ok().body(user.getFigures());

        } catch (IdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public ResponseEntity deleteFigure(ObjectId idFigure) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();

        try {
            UserResources user = userRepository.findById(myUserDetails.getId()).orElseThrow(
                    () -> new IdException("UserResources not found with id : " + myUserDetails.getId().toHexString())
            );

            List<Figure> figureList = user.getFigures();
            List<Figure> newFigureList = figureList
                    .stream()
                    .filter(figure -> !figure.getId().equals(idFigure.toHexString()))
                    .collect(Collectors.toList());

            user.setFigures(newFigureList);
            userRepository.save(user);

            IdDto idDto = IdDtoBuilder
                    .builder()
                    .withId(idFigure)
                    .build();

            return ResponseEntity.ok().body(idDto);

        } catch (IdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
