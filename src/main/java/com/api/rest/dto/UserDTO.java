package com.api.rest.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
public class UserDTO implements Serializable {
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String password;
    private Set<PhoneDTO> phones;
}
