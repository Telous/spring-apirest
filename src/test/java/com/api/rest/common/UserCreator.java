package com.api.rest.common;

import com.api.rest.dto.PhoneDTO;
import com.api.rest.dto.UserDTO;

import java.util.HashSet;
import java.util.Set;

public class UserCreator {

    public static UserDTO userDto(){
        UserDTO userDTO = new UserDTO();

        PhoneDTO phoneDTO = new PhoneDTO();
        Set<PhoneDTO> phoneDTOS = new HashSet<>();
        phoneDTO.setNumber(1234567);
        phoneDTO.setCityCode(12);
        phoneDTO.setCountryCode(57);
        phoneDTOS.add(phoneDTO);
        userDTO.setName("prueba");
        userDTO.setEmail("a@domain.com");
        userDTO.setPassword("snch334nc*c");
        userDTO.setPhones(phoneDTOS);
        return userDTO;
    }
}
