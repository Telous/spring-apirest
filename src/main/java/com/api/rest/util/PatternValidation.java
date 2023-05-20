package com.api.rest.util;

import com.api.rest.config.RegexPattern;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class PatternValidation {

    private final RegexPattern regexPattern;

    public PatternValidation(RegexPattern regexPattern) {
        this.regexPattern = regexPattern;
    }

    public boolean patternEmail(String email) {
        return Pattern.compile(regexPattern.getEmail())
                .matcher(email)
                .matches();
    }

    public boolean patternPassword(String password) {
        return Pattern.compile(regexPattern.getPassword())
                .matcher(password)
                .matches();
    }
}
