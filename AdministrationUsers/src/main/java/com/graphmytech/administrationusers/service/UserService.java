package com.graphmytech.administrationusers.service;

import com.graphmytech.administrationusers.dto.UserDTO;
import com.graphmytech.administrationusers.model.User;

import java.util.List;

public interface UserService {


    /**
     *
     * @param name
     * @param password
     * @return
     */
    User createUser(String name, String password);

    /**
     *
     * @param userId
     * @param user
     * @return
     */
    User updateUser(Long userId, UserDTO user);

    /**
     * Retrieve all users from DB
     * @return
     */
    List<User> getAllUsers();

    /**
     * Delete the user with the given userId
     * @param userId the userId we want to delete
     */
    void deleteUser(Long userId);

}
