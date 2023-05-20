package com.api.rest.controller;

import com.api.rest.dto.ResponseDTO;
import com.api.rest.dto.UserDTO;
import com.api.rest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> users(@RequestBody UserDTO users) {
        return new ResponseEntity<>(userService.add(users), HttpStatus.CREATED);
    }
}
