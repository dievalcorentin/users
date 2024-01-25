package com.graphmytech.administrationusers.mapper;

import com.graphmytech.administrationusers.dto.UserDTO;
import com.graphmytech.administrationusers.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDTO map(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());

        return userDTO;
    }

    public static List<UserDTO> map(List<User> users) {
        return users.stream()
                .map(UserMapper::map)
//              .map(user->UserMapper.map(user))
                .collect(Collectors.toList());
    }

}
