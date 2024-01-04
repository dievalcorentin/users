package com.graphmytech.administrationusers.mapper;

import com.graphmytech.administrationusers.dto.UserDTO;
import com.graphmytech.administrationusers.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDTO map(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setAge(user.getAge());
        userDTO.setName(user.getName());

        return userDTO;
    }

    public static List<UserDTO> map(List<User> users) {
        return users.stream()
                .map(UserMapper::map)
//              .map(user->UserMapper.map(user))
                .collect(Collectors.toList());
    }
}
