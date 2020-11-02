package com.datn.app.controller;

import com.datn.app.dto.UserDto;
import com.datn.app.service.UserService;
import com.datn.app.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController{
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> save(@RequestBody UserDto dto){
        return new ResponseEntity<>(userService.save(dto), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<UserDto> update(@RequestBody UserDto dto){
        return new ResponseEntity<>(userService.save(dto), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(userService.deleteById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Page<UserDto>> search(@RequestParam(required = false) String page, @RequestParam(required = false) String limit){
        Pageable pageable = AppUtil.getPageable(page, limit);
        return new ResponseEntity(userService.search(pageable), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> findByUsername(@PathVariable String username) throws Exception{
        return new ResponseEntity<>(userService.findByUsername(username), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }
}
