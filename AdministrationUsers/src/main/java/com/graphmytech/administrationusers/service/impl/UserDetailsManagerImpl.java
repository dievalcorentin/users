package com.graphmytech.administrationusers.service.impl;
import com.graphmytech.administrationusers.model.User;
import com.graphmytech.administrationusers.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

import java.util.Optional;
public class UserDetailsManagerImpl implements UserDetailsManager {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDetailsManagerImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createUser(UserDetails user) {
        User newUser = new User();
        newUser.setEmail(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword())); // Use password encoder for security
        userRepository.save(newUser);
    }

    @Override
    public void updateUser(UserDetails user) {
        Optional<User> optionalUser = userRepository.findByEmail(user.getUsername());
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();

            userRepository.save(existingUser);
        } else {
            throw new UsernameNotFoundException("User not found with email: " + user.getUsername());
        }
    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteByEmail(username);
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        String currentLoggedInUserEmail = getCurrentUserEmail();

        Optional<User> optionalUser = userRepository.findByEmail(currentLoggedInUserEmail);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            if (passwordEncoder.matches(oldPassword, user.getPassword())) {
                user.setPassword(passwordEncoder.encode(newPassword));
                userRepository.save(user);
            } else {
                throw new IllegalArgumentException("Old password does not match");
            }
        } else {
            throw new UsernameNotFoundException("User not found with email: " + currentLoggedInUserEmail);
        }
    }

    private String getCurrentUserEmail() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails userDetails) {
            return userDetails.getUsername();
        } else {
            throw new IllegalStateException("Unable to retrieve current user's email");
        }
    }

    @Override
    public boolean userExists(String username) {
        return userRepository.existsByEmail(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
