package com.spring.workshop.jwt.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String username;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)//loads roles once user is loaded
    private Collection<Role> roles = new ArrayList<>();

}
