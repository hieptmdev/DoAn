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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.security.Principal;
import java.text.ParseException;

@RestController
@RequestMapping("/user")
public class UserController{
    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<UserDto> saveOrUpdate(@RequestBody UserDto dto, HttpServletRequest request){
        return new ResponseEntity<>(userService.saveOrUpdate(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable Long id, HttpServletRequest request){
        return new ResponseEntity(userService.deleteById(id), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<UserDto>> search(@RequestParam(required = false) String page,
                                                @RequestParam(required = false) String limit,
                                                @RequestParam(required = false) String code,
                                                @RequestParam(required = false) String name,
                                                @RequestParam(required = false) String username,
                                                @RequestParam(value = "unit", required = false) String unitId){
        Pageable pageable = AppUtil.getPageable(page, limit);
        return new ResponseEntity(userService.search(pageable, code, name, username, unitId), HttpStatus.OK);
    }

    @GetMapping("/search-teacher")
    public ResponseEntity<Page<UserDto>> searchTeacher(@RequestParam(required = false) String page,
                                                @RequestParam(required = false) String limit,
                                                @RequestParam(required = false) String code,
                                                @RequestParam(required = false) String name,
                                                @RequestParam(value = "department", required = false) String departmentId,
                                                @RequestParam(value = "unit", required = false) String unitId){
        Pageable pageable = AppUtil.getPageable(page, limit);
        return new ResponseEntity(userService.searchTeacher(pageable, code, name, departmentId, unitId), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> findByUsername(@PathVariable String username, HttpServletRequest request) throws Exception{
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
            message.setMessage("Bad request!");
            message.setCode(HttpStatus.BAD_REQUEST.value());
        } else {
            message.setMessage("Change password success!");
            message.setCode(HttpStatus.OK.value());
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/lock/{id}")
    public ResponseEntity<MessageResponse> lockUser(@PathVariable Long id){
        MessageResponse message;
        boolean check = userService.lockUser(id);
        if (check) message = new MessageResponse(HttpStatus.OK.value(), "User locked!");
        else message = new MessageResponse(HttpStatus.BAD_REQUEST.value(), "User lock fail!");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/open-lock/{id}")
    public ResponseEntity<MessageResponse> openLockUser(@PathVariable Long id){
        MessageResponse message;
        boolean check = userService.openLockUser(id);
        if (check) message = new MessageResponse(HttpStatus.OK.value(), "User opened!");
        else message = new MessageResponse(HttpStatus.BAD_REQUEST.value(), "User open fail!");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/check-permission-sys")
    public ResponseEntity checkPermissionSys(HttpServletRequest request){
        UserDto dto = userService.findByUsername(request.getUserPrincipal().getName());
        if (dto == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        if (!dto.getRoleCode().equals("SYSADMIN")){
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all-teacher-by-department/{departmentId}")
    public ResponseEntity findAllTeacherByDepartment(@PathVariable Long departmentId){
        return new ResponseEntity(userService.findAllTeacherByDepartment(departmentId), HttpStatus.OK);
    }

    @GetMapping("/teachers")
    public ResponseEntity findAllTeacher(HttpServletRequest request){
        return new ResponseEntity(userService.findAllTeacher(), HttpStatus.OK);
    }
}
