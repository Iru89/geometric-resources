package com.tfg.geometricresources.controller;

import com.tfg.geometricresources.model.dto.AddFigureDto;
import com.tfg.geometricresources.model.dto.IdDto;
import com.tfg.geometricresources.service.FigureService;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public ResponseEntity addFigure(@RequestBody AddFigureDto addFigureDto){
        return figureService.add(addFigureDto.getFigure(), addFigureDto.getUserId());
    }

    @RequestMapping(value = "/figures", method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity getList(@RequestBody IdDto userId){
        return figureService.getList(new ObjectId(userId.getId()));
    }

    @RequestMapping(value = "/figure", method = RequestMethod.DELETE)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity deleteFigure(@RequestBody IdDto idFigure){
        return figureService.deleteFigure(new ObjectId(idFigure.getId()));
    }



}
