package com.api.rest.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Users implements Serializable {

    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid")
    private UUID id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime modified;

    @Column
    private LocalDateTime lastLogin;

    @Column
    private String token;

    @Column
    private Boolean active;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Phone> phones;

}
