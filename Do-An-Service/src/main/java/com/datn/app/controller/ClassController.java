package com.datn.app.controller;

import com.datn.app.service.ClassService;
import com.datn.app.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/class-subject")
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping("/search")
    public ResponseEntity search(@RequestParam(required = false) String page,
                                 @RequestParam(required = false) String limit,
                                 @RequestParam(required = false) String code,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(value = "course", required = false) String courseId,
                                 @RequestParam(value = "unit", required = false) String unitId,
                                 @RequestParam(value = "department", required = false) String departmentId,
                                 @RequestParam(value = "subject", required = false) String subjectId){
        Pageable pageable = AppUtil.getPageable(page, limit);
        return new ResponseEntity(classService.search(pageable, code, name, courseId, unitId, departmentId, subjectId),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id, HttpServletRequest request){
        return new ResponseEntity(classService.findById(id), HttpStatus.OK);
    }
}
