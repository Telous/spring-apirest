package com.api.rest.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
public class Phone implements Serializable {

    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid")
    private UUID id;

    @Column(nullable = false)
    private UUID userId;

    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false)
    private Integer cityCode;

    @Column(nullable = false)
    private Integer countryCode;

    @ManyToOne
    @JoinColumn(name="userId", nullable=false, insertable = false, updatable = false)
    private Users user;
}
