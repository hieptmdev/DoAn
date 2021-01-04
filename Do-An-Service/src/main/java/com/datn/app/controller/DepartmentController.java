package com.datn.app.controller;

import com.datn.app.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity findAll(HttpServletRequest request){
        return new ResponseEntity(departmentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/unit/{unitId}")
    public ResponseEntity findAllByUnit(@PathVariable Long unitId, HttpServletRequest request){
        return new ResponseEntity(departmentService.findAllByUnit(unitId), HttpStatus.OK);
    }
}
