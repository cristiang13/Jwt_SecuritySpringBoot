package com.app.jwtSecurity.service;

import java.util.List;

import javax.transaction.Transactional;

import com.app.jwtSecurity.model.Role;
import com.app.jwtSecurity.model.User;
import com.app.jwtSecurity.repository.RoleRepository;
import com.app.jwtSecurity.repository.UserRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Override
    public User saveUser(User user) {
       log.info("saving new user {} to database", user.getName());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving new role {} to database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        log.info("adding role {} to user {}", rolename, username);
        User user= userRepository.findByUsername(username);
        Role role= roleRepository.findByName(rolename);
        user.getRoles().add(role);

        
    }

    @Override
    public User getUser(String username) {
        log.info("fetching to user {}",  username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUser() {
        log.info("fetching all users");
        return userRepository.findAll();
    }
    
}
