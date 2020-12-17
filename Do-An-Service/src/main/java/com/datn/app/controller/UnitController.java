package com.datn.app.controller;

import com.datn.app.dto.UnitDto;
import com.datn.app.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/unit")
public class UnitController {
    @Autowired
    private UnitService unitService;

    @GetMapping("/all-for-student/{unitId}")
    public ResponseEntity<List<UnitDto>> findAllForStudent(@PathVariable Long unitId){
        return new ResponseEntity(unitService.getAllForStudent(unitId), HttpStatus.OK);
    }
}
