package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.model.User;
import com.example.studentmanagement.repository.IUserRepository;
import com.example.studentmanagement.repository.impl.UserRepository;
import com.example.studentmanagement.service.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private IUserRepository userRepository = new UserRepository();

    @Override
    public User findByUsernameOrEmail(String usernameOrEmail) {
        return userRepository.findByUsernameOrEmail(usernameOrEmail);
    }

    @Override
    public List<String> findRolesByUsername(String username) {
        return userRepository.findRolesByUsername(username);
    }

    @Override
    public void updatePasswordByEmail(String hashPassword, String email) {
        userRepository.updatePasswordByEmail(hashPassword, email);
    }
}
