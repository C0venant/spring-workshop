package com.spring.workshop.jwt.service;

import com.spring.workshop.jwt.domain.AppUser;
import com.spring.workshop.jwt.domain.Role;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username ,String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
