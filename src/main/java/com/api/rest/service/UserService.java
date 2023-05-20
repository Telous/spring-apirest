package com.api.rest.service;

import com.api.rest.dto.ResponseDTO;
import com.api.rest.dto.UserDTO;
import com.api.rest.entity.Phone;
import com.api.rest.entity.Users;
import com.api.rest.exception.PatternException;
import com.api.rest.repository.UserRepository;
import com.api.rest.util.PatternValidation;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PatternValidation patternValidation;

    public UserService(UserRepository userRepository, PatternValidation patternValidation) {
        this.userRepository = userRepository;
        this.patternValidation = patternValidation;
    }

    public ResponseDTO add(UserDTO userDTO) {

        Users users = new Users();
        users.setName(userDTO.getName());
        users.setEmail(emailValidation(userDTO.getEmail()));
        users.setPassword(passwordValidation(userDTO.getPassword()));
        users.setCreated(LocalDateTime.now());
        users.setModified(LocalDateTime.now());
        users.setLastLogin(LocalDateTime.now());
        users.setToken(UUID.randomUUID().toString());
        users.setActive(true);

        Users saveUser = userRepository.save(users);

        List<Phone> phoneList = new ArrayList<>();
        userDTO.getPhones().forEach(p -> {
            Phone ph = new Phone();
            ph.setUserId(saveUser.getId());
            ph.setNumber(p.getNumber());
            ph.setCityCode(p.getCityCode());
            ph.setCountryCode(p.getCountryCode());
            phoneList.add(ph);
        });
        users.setPhones(phoneList);
        userRepository.saveAndFlush(users);

        return new ResponseDTO(
                users.getId(), users.getCreated(), users.getModified(), users.getLastLogin(),
                users.getToken(), users.getActive());
    }

    private String emailValidation(String email) {
        if (!patternValidation.patternEmail(email)){
            throw new PatternException("Email not valid");
        }
        return email;
    }

    private String passwordValidation(String password) {
        if (!patternValidation.patternPassword(password)){
            throw new PatternException("Password not valid");
        }
        return password;
    }

}
