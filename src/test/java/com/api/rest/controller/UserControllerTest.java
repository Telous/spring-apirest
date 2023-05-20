package com.api.rest.controller;

import com.api.rest.common.UserCreator;
import com.api.rest.dto.ResponseDTO;
import com.api.rest.dto.UserDTO;
import com.api.rest.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    void setUp() {
        userController = new UserController(userService);
    }

    @Test
    void users() {
        UserDTO input = UserCreator.userDto();
        Mockito.when(userService.add(input))
                .thenReturn(new ResponseDTO(
                        UUID.randomUUID(),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        "token",
                        true
                ));
        userController.users(input);
    }
}