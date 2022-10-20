package com.easybuy.controller;

import com.easybuy.service.UserService;
import com.easybuy.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/Users")
    public ResponseEntity<List<UserVO>> getAllUsers(){
        List<UserVO> usersVO = userService.getAllUsers();
        return new ResponseEntity<>(usersVO, HttpStatus.OK);
    }
}
