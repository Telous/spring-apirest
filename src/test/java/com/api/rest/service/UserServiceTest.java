package com.api.rest.service;

import com.api.rest.common.UserCreator;
import com.api.rest.entity.Users;
import com.api.rest.exception.PatternException;
import com.api.rest.repository.UserRepository;
import com.api.rest.util.PatternValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;
    @Mock
    private PatternValidation patternValidation;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository , patternValidation);
    }

    @Test
    void add() {
        Mockito.when(patternValidation.patternEmail(any()))
                .thenReturn(true);

        Mockito.when(patternValidation.patternPassword(any()))
                .thenReturn(true);

        Mockito.when(userRepository.save(any()))
                .thenReturn(new Users());

        userService.add(UserCreator.userDto());
    }

    @Test
    void add_email_invalid() {
        Mockito.when(patternValidation.patternEmail(any()))
                .thenReturn(false);

        PatternException thrown =
                Assertions.assertThrows(PatternException.class, () -> userService.add(UserCreator.userDto()));
        Assertions.assertEquals("Email not valid", thrown.getMessage());
    }

    @Test
    void add_password_invalid() {
        Mockito.when(patternValidation.patternEmail(any()))
                .thenReturn(true);

        Mockito.when(patternValidation.patternPassword(any()))
                .thenReturn(false);

        PatternException thrown =
                Assertions.assertThrows(PatternException.class, () -> userService.add(UserCreator.userDto()));
        Assertions.assertEquals("Password not valid", thrown.getMessage());
    }
}