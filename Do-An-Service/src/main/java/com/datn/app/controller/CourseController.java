package com.datn.app.controller;

import com.datn.app.dto.CourseDto;
import com.datn.app.entity.Course;
import com.datn.app.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    public ResponseEntity<List<CourseDto>> findAll(){
        return new ResponseEntity(courseService.getAllCourses(), HttpStatus.OK);
    }
}
