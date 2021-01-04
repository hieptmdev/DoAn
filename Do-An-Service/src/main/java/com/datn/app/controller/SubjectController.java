package com.datn.app.controller;

import com.datn.app.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public ResponseEntity findAll(HttpServletRequest request){
        return new ResponseEntity(subjectService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity findAllByDepartment(@PathVariable Long departmentId, HttpServletRequest request){
        return new ResponseEntity(subjectService.findAllByDepartment(departmentId), HttpStatus.OK);
    }
}
