package com.eraboy.usercrud.controller;

import com.eraboy.usercrud.entity.User;
import com.eraboy.usercrud.service.custom.UserService;
import com.eraboy.usercrud.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllUsers(){
        return new ResponseUtil(200, "ok", userService.getAllUser());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveUser(@RequestBody User user){
        userService.saveUser(user);
        return new ResponseUtil(200, "user saved", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateUser(@RequestBody User user){
        userService.updateUser(user);
        return new ResponseUtil(200, "user updated", null);
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteUser(@RequestParam long id){
        userService.deleteUser(id);
        return new ResponseUtil(200, "user deleted", null);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchUser(@PathVariable long id){
        userService.searchUser(id);
        return new ResponseUtil(200, "user search completed", null);
    }
}