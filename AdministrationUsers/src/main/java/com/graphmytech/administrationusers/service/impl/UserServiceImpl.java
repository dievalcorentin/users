package com.graphmytech.administrationusers.service.impl;

import com.graphmytech.administrationusers.dto.UserDTO;
import com.graphmytech.administrationusers.mapper.UserMapper;
import com.graphmytech.administrationusers.repository.UserRepository;
import com.graphmytech.administrationusers.service.UserService;
import com.graphmytech.administrationusers.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    // Method to create a new user
    @Override
    public User createUser(String name, Integer age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return userRepository.save(user);
    }


    // Method to update an existing user
    @Override
    public User updateUser(Long userId, UserDTO userDTO) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setName(userDTO.getName());
        existingUser.setAge(userDTO.getAge());
        return userRepository.save(existingUser);
    }

    // Method to retrive the list of users
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Method to delete a user
    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    private void deleteAllUser() {
        userRepository.deleteAll();
    }
}
