package com.example.firstdemo.Controller;

import com.example.firstdemo.Service.UserService;
import com.example.firstdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Long id){
        return  new ResponseEntity<>(userService.updateUser(user,id),HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.deleteUser(id),HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> selectUser(@PathVariable Long id){
        return  new ResponseEntity<>(userService.selectUser(id),HttpStatus.OK);
    }
    @GetMapping("")
    public  ResponseEntity<List<User>> selectAllUser(){
        return new ResponseEntity<>(userService.selectAll(),HttpStatus.OK);
    }
}
