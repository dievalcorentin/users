package com.graphmytech.administrationusers.mapper;

import com.graphmytech.administrationusers.dto.UserDTO;
import com.graphmytech.administrationusers.model.User;

public class UserMapper {

    public static UserDTO map(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setAge(user.getAge());
        userDTO.setName(user.getName());

        return userDTO;
    }
}
