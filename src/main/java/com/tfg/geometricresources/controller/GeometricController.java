package com.tfg.geometricresources.controller;

import com.tfg.geometricresources.model.MyUserDetails;
import com.tfg.geometricresources.model.dto.FigureDto;
import com.tfg.geometricresources.model.dto.IdDto;
import com.tfg.geometricresources.service.FigureService;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/geometric")
public class GeometricController {

    private FigureService figureService;

    public GeometricController(FigureService figureService) {
        this.figureService = figureService;
    }

    @RequestMapping(value = "/figure", method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity addFigure(@RequestBody FigureDto figureDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        ObjectId userId = myUserDetails.getId();
        return figureService.add(figureDto.getFigure(), userId);
    }

    @RequestMapping(value = "/figure", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity getList(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        ObjectId userId = myUserDetails.getId();
        return figureService.getList(userId);
    }

    @RequestMapping(value = "/figure", method = RequestMethod.DELETE)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity deleteFigure(@RequestBody IdDto idFigure){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        ObjectId userId = myUserDetails.getId();
        ObjectId figureId = new ObjectId(idFigure.getId());
        return figureService.deleteFigure(figureId, userId);
    }



}
