package com.api.rest.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class PhoneDTO implements Serializable {

    @NonNull
    private Integer number;
    @NonNull
    private Integer cityCode;
    @NonNull
    private Integer countryCode;
}
