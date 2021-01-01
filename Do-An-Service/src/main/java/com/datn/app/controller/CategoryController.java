package com.datn.app.controller;

import com.datn.app.dto.CategoryDto;
import com.datn.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController{
    @Autowired
    private CategoryService categoryService;

    @PostMapping("")
    public ResponseEntity<CategoryDto> save(@RequestBody CategoryDto dto){
        return null;
    }

    @PutMapping("")
    public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto dto){
        return null;
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity deleteById(@PathVariable Long categoryId){
        return null;
    }

    @GetMapping("/parent")
    public ResponseEntity<List<CategoryDto>> findAllParentByRole(HttpServletRequest request){
        return new ResponseEntity<>(categoryService.findAllParentByRole(request), HttpStatus.OK);
    }

    @GetMapping("/child/{parentId}")
    public ResponseEntity<List<CategoryDto>> findAllChildByRoleAndParent(@PathVariable Long parentId, HttpServletRequest request){
        return new ResponseEntity<>(categoryService.findAllChildByRoleAndParent(parentId, request), HttpStatus.OK);
    }
}
