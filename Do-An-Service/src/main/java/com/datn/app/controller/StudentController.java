package com.datn.app.controller;

import com.datn.app.dto.MessageResponse;
import com.datn.app.dto.StudentsDto;
import com.datn.app.dto.StudyScoreDto;
import com.datn.app.dto.UserDto;
import com.datn.app.service.StudentService;
import com.datn.app.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/search")
    public ResponseEntity<Page<UserDto>> search(@RequestParam(required = false) String page,
                                                @RequestParam(required = false) String limit,
                                                @RequestParam(required = false) String code,
                                                @RequestParam(required = false) String name,
                                                @RequestParam(name = "course", required = false) String courseId,
                                                @RequestParam(name = "unit", required = false) String unitId){
        Pageable pageable = AppUtil.getPageable(page, limit);
        return new ResponseEntity(studentService.search(pageable, code, name, courseId, unitId), HttpStatus.OK);
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<StudentsDto> findByCode(@PathVariable String code){
        return new ResponseEntity(studentService.findByCode(code), HttpStatus.OK);
    }

    @GetMapping("/score/{code}")
    public ResponseEntity<List<StudyScoreDto>> findAllScoreByStudentCode(@PathVariable String code){
        return new ResponseEntity(studentService.findAllScore(code), HttpStatus.OK);
    }

    @GetMapping("/export-score/{code}")
    public ResponseEntity exportScore(@PathVariable String code) {
        return null;
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable Long studentId, HttpServletRequest request){
        MessageResponse msg = studentService.deleteById(studentId);
        return new ResponseEntity(msg, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentsDto> saveOrUpdate(@RequestBody StudentsDto dto, HttpServletRequest req){
        return new ResponseEntity(studentService.saveOrUpdate(dto), HttpStatus.OK);
    }
}
