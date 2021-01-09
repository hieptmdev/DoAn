package com.datn.app.controller;

import com.datn.app.dto.ClassDto;
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

    @PostMapping("/delete-class-detail")
    public ResponseEntity deleteClassDetail(@RequestBody ClassDto dto, HttpServletRequest request){
        return new ResponseEntity(classService.deleteClassDetails(dto, request), HttpStatus.OK);
    }

    @DeleteMapping("/class-detail/{id}")
    public ResponseEntity deleteClassDetail(@PathVariable Long id, HttpServletRequest request){
        return new ResponseEntity(classService.deleteClassDetails(id, request), HttpStatus.OK);
    }

    @GetMapping("/find-all-class-same-subject")
    public ResponseEntity findAllClassSameSubject(@RequestParam String classSubjectId,
                                                  @RequestParam String subjectId,
                                                  @RequestParam String courseId,
                                                  HttpServletRequest request){
        return new ResponseEntity(classService.findAllClassSameSubject(classSubjectId, subjectId, courseId), HttpStatus.OK);
    }

    @PostMapping("/transfer")
    public ResponseEntity transferClassDetails(@RequestBody ClassDto dto, @RequestParam String classSubjectId, HttpServletRequest request){
        return new ResponseEntity(classService.transfer(dto, classSubjectId, request), HttpStatus.OK);
    }

    @PutMapping("/transfer")
    public ResponseEntity transferClassDetails(@RequestParam String classDetailId, @RequestParam String classSubjectId, HttpServletRequest request){
        return new ResponseEntity(classService.transfer(classDetailId, classSubjectId, request), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveOrUpdate(@RequestBody ClassDto dto, HttpServletRequest request){
        return new ResponseEntity(classService.saveOrUpdate(dto, request), HttpStatus.OK);
    }
}
