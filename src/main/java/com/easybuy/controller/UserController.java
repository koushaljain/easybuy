package com.easybuy.controller;

import com.easybuy.service.UserService;
import com.easybuy.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/easybuy")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/Users")
    public ResponseEntity<List<UserVO>> getAllUsers() {
        List<UserVO> usersVO = userService.getAllUsers();
        return new ResponseEntity<>(usersVO, HttpStatus.OK);
    }

    @GetMapping("/Users/{userid}")
    public ResponseEntity<UserVO> getUserById(@PathVariable("userid") int userId) throws Exception {
        UserVO userVO = userService.getUserById(userId);
        return new ResponseEntity<>(userVO, HttpStatus.OK);
    }

    @PostMapping("/Users")
    public ResponseEntity<Integer> saveUser(@RequestBody UserVO userVO) {
        Integer savedId = userService.saveUser(userVO);
        return new ResponseEntity<>(savedId, HttpStatus.CREATED);
    }

    @DeleteMapping("/Users/{userid}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("userid") int userId) {
        Boolean isDeleted = userService.deleteById(userId);
        return new ResponseEntity<>(isDeleted, HttpStatus.NO_CONTENT);
    }

    @PutMapping("/Users/{userid}")
    public ResponseEntity<Boolean> updateUser(@PathVariable("userid") int userId, @RequestBody UserVO userVO) {
        Boolean isUpdated = userService.updateUser(userId, userVO);
        return new ResponseEntity<>(isUpdated, HttpStatus.OK);
    }
}
