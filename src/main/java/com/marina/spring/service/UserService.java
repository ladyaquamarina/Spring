package com.marina.spring.service;

import java.util.List;
import java.util.Optional;

import com.marina.spring.model.User;
import com.marina.spring.model.UserRole;

public interface UserService {
    public User createUser(String username, String password, UserRole role);

    public User createUser(String username, String password);

    public Optional<User> validateUser(String username, String password);

    public List<User> findAllUsers();

    public User findUser(String username);

    public void updateUser(String username, String newUsername, String password, UserRole role);

    public void deleteUser(String username);
}
