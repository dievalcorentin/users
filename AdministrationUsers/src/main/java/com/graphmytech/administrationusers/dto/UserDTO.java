package com.graphmytech.administrationusers.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
    @Schema(name = "User Name", example = "Toto", required = true)
    private String name;
    @Schema(name = "User Age", example = "25", required = true)
    private Integer age;

    // Default constructor
    public UserDTO() {
    }

    public UserDTO(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
