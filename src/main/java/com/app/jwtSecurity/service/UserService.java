package com.app.jwtSecurity.service;

import java.util.List;

import com.app.jwtSecurity.model.Role;
import com.app.jwtSecurity.model.User;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String rolename);
    User getUser(String username);
    List<User>getUser();
}
