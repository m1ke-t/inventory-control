package com.mititch.inventoryctrl.controllers;

import com.mititch.inventoryctrl.dto.UserDetailsView;
import com.mititch.inventoryctrl.model.User;
import com.mititch.inventoryctrl.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
    @GetMapping(value = "/auth")
    public UserDetailsView getDetailsByCredentials(@RequestHeader(value = "Authorization") String auth) {
        return userService.loadDetailsByCredentials(auth);
    }

    @GetMapping(value = "/users/list")
    public List<User> getAll(@RequestHeader(value = "Authorization") String auth) {
        return userService.listAll();
    }

}