package com.chemicalgears.chemicalapi.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class UserCredentials implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    protected UserCredentials() {
    }

    public UserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
