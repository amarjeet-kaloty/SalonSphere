package com.salonsphere.service.impl;

import com.salonsphere.exception.UserException;
import com.salonsphere.model.User;
import com.salonsphere.repository.UserRepository;
import com.salonsphere.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) throws UserException {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        throw new UserException("user not found");
    }

    @Override
    public User updateUser(User user, Long id) throws UserException {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isEmpty()){
            throw new UserException("User not found.");
        }
        User existingUser = optional.get();

        existingUser.setFullName(user.getFullName());
        existingUser.setEmail(user.getEmail());
        existingUser.setRole(user.getRole());
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPhone());

        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) throws UserException {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isEmpty()){
            throw new UserException("User not found.");
        }

        userRepository.deleteById(id);
    }
}
