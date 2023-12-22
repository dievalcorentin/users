package com.graphmytech.administrationusers.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
    private String name;
    private Integer age;

    // Default constructor
    public UserDTO() {
    }

    public UserDTO(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
