package com.graphmytech.administrationusers.service;

import com.graphmytech.administrationusers.dto.UserDTO;
import com.graphmytech.administrationusers.repository.UserRepository;
import com.graphmytech.administrationusers.table.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Method to create a new user
    public User createUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());
        return userRepository.save(user);
    }

    // Method to update an existing user
    public User updateUser(Long userId, UserDTO userDTO) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setName(userDTO.getName());
        existingUser.setAge(userDTO.getAge());
        return userRepository.save(existingUser);
    }

    // Method to delete a user
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
