package com.datn.app.controller;

import com.datn.app.dto.FormChangePassword;
import com.datn.app.dto.MessageResponse;
import com.datn.app.dto.UserDto;
import com.datn.app.service.UserService;
import com.datn.app.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/user")
//@CrossOrigin(origins = "http://localhost:4201", maxAge = 3600L)
public class UserController{
    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<UserDto> save(@RequestBody UserDto dto){
        return new ResponseEntity<>(userService.save(dto), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<UserDto> update(@RequestBody UserDto dto){
        return new ResponseEntity<>(userService.save(dto), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(userService.deleteById(id), HttpStatus.OK);
    }

    @GetMapping("/search")
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

    @PostMapping("/send-code")
    public ResponseEntity<MessageResponse> sendCode(@RequestBody UserDto dto) throws ParseException {
        MessageResponse message = new MessageResponse();
        Boolean check = userService.sendCode(dto);
        if (!check) {
            message.setMessage("Send code fail!");
            message.setCode(HttpStatus.BAD_REQUEST.value());
        }else {
            message.setMessage("Send code success!");
            message.setCode(HttpStatus.OK.value());
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/change-password")
    public ResponseEntity<MessageResponse> changePassword(@RequestBody FormChangePassword dto){
        MessageResponse message = new MessageResponse();
        Integer check = userService.changePassword(dto);
        if (check == -1) {
            message.setMessage("Change password fail!");
            message.setCode(HttpStatus.NOT_FOUND.value());
        }else if (check == 0){
            message.setMessage("");
            message.setCode(HttpStatus.BAD_REQUEST.value());
        } else {
            message.setMessage("Change password success!");
            message.setCode(HttpStatus.OK.value());
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
