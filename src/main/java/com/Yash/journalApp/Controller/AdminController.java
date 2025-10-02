package com.Yash.journalApp.Controller;

import com.Yash.journalApp.Entity.User;
import com.Yash.journalApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/all-users")
    public ResponseEntity<?> GetAllUsers()
    {
        List<User> users = userService.GetAllUsers();
        if(users != null && !users.isEmpty())
        {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create-admin")
    public ResponseEntity<?> CreateAdminUser(@RequestBody User user)
    {
        userService.SaveAdmin(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
