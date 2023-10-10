package com.example.studentmanagement.service;

import com.example.studentmanagement.model.User;

import java.util.List;

public interface IUserService {
    User findByUsernameOrEmail(String usernameOrEmail);

    List<String> findRolesByUsername(String username);

    void updatePasswordByEmail(String hashPassword, String email);
}
