package com.example.studentmanagement.repository;

import com.example.studentmanagement.model.User;

import java.util.List;

public interface IUserRepository {
    User findByUsernameOrEmail(String usernameOrEmail);

    List<String> findRolesByUsername(String username);

    void updatePasswordByEmail(String hashPassword, String email);
}
