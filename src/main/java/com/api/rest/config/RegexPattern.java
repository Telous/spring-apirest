package com.api.rest.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "regex-patterns")
@Data
public class RegexPattern {
    private String email;
    private String password;
}
