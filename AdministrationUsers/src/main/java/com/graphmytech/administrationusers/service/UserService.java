package com.graphmytech.administrationusers.service;

import com.graphmytech.administrationusers.dto.UserDTO;
import com.graphmytech.administrationusers.model.User;

import java.util.List;

public interface UserService {


    /**
     *
     * @param name
     * @param age
     * @return
     */
    User createUser(String name, Integer age);

    /**
     *
     * @param userId
     * @param userDTO
     * @return
     */
    User updateUser(Long userId, UserDTO userDTO);

    /**
     * Retrieve all users from DB
     * @return
     */
    List<UserDTO> getAllUsers();

    /**
     * Delete the user with the given userId
     * @param userId the userId we want to delete
     */
    void deleteUser(Long userId);
}
