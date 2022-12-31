package com.springboot.security.jpa.springsecurityjpa.controller;

import com.springboot.security.jpa.springsecurityjpa.UserDetailsServiceImpl;
import com.springboot.security.jpa.springsecurityjpa.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping(value = "/")
public class NewController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @GetMapping("/user")
    public String getUser()
    {
        return "<h1>Hi user Accessible</h2>>";
    }

    @GetMapping( "/admin")
    public String getAdmin()
    {
        return "<h1>Hi Admin Accessible</h2>>";
    }


    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }
    @PostMapping("/saveUser")
    public ResponseEntity<Users> saveUser(@RequestBody Users users)
    {
        Users user=userDetailsService.saveUser(users);

        if(!ObjectUtils.isEmpty(users))
        return new ResponseEntity<>(user,HttpStatus.CREATED);
        else
            return new ResponseEntity<>(user,HttpStatus.NOT_FOUND);

    }
}
