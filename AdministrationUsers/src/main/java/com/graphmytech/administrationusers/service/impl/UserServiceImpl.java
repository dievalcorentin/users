package com.graphmytech.administrationusers.service.impl;

import com.graphmytech.administrationusers.dto.UserDTO;
import com.graphmytech.administrationusers.repository.UserRepository;
import com.graphmytech.administrationusers.service.UserService;
import com.graphmytech.administrationusers.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Method to create a new user
    @Override
    public User createUser(String name, String password) {
        User user = new User();
        user.setEmail(name);
        user.setPassword(passwordEncoder.encode(password));
        user.setCreatedDate(LocalDateTime.now());
        user.setCountTotalProject(0);
        user.setMaxCountProject(10);
        user.setMaxCountRequest(10);
        return userRepository.save(user);
    }


//    // Method to update an existing user
//    @Override
//    public User updateUser(Long userId, UserDTO userDTO) {
//        User existingUser = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        existingUser.setEmail(userDTO.getEmail());
//        existingUser.setPassword(userDTO.getPassword());
//        return userRepository.save(existingUser);
//    }

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

    @Override
    public User updateUser(Long id, UserDTO userDetails) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            us
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            userRepository.save(user);
            return user;
        }
        return null;
    }

}
