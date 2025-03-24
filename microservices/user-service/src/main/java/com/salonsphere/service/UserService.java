package com.salonsphere.service;

import com.salonsphere.exception.UserException;
import com.salonsphere.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUserById(Long id) throws UserException;

    List<User> getAllUsers();

    void deleteUser(Long id) throws UserException;

    User updateUser(User user, Long id) throws UserException;
}
