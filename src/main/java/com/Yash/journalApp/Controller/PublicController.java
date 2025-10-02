package com.Yash.journalApp.Controller;

import com.Yash.journalApp.Entity.User;
import com.Yash.journalApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Public")
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("/health-check")
    public String HealthDetection()
    {
        return "Ok";
    }

    @PostMapping ("/create-user")
    public ResponseEntity<?> CreateUser(@RequestBody User user)
    {
        userService.SaveNewUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
