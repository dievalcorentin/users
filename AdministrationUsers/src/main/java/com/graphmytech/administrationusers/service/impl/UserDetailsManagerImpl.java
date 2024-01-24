package com.graphmytech.administrationusers.service.impl;
import com.graphmytech.administrationusers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

public class UserDetailsManagerImpl implements UserDetailsManager {

    private UserRepository userRepository;

    public UserDetailsManagerImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserDetails user) {
    }
    @Override
    public void updateUser(UserDetails user) {
    }
    @Override
    public void deleteUser(String username) {
    }
    @Override
    public void changePassword(String oldPassword, String newPassword) {
    }
    @Override
    public boolean userExists(String username) {
        return false;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
