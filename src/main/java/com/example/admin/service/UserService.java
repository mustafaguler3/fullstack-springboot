package com.example.admin.service;

import com.example.admin.entities.User;

public interface UserService {
    User loadUserByEmail(String email);
    User createUser(String email,String password);
    void assignRoleToUser(String email,String roleName);
}
