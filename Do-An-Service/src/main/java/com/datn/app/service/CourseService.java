package com.datn.app.service;

import com.datn.app.dao.idao.CourseDao;
import com.datn.app.dto.CourseDto;
import com.datn.app.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired
    private CourseDao courseDao;

    public List<CourseDto> getAllCourses(){
        List<Course> courseList = courseDao.findAll();
        if (courseList != null && !courseList.isEmpty()){
            return courseList.stream().map(Course::convertToDto).collect(Collectors.toList());
        }
        return null;
    }
}
