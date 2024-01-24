package com.graphmytech.administrationusers.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
    @Schema(description = "User Name", example = "Toto")
    private String name;
    @Schema(description = "User Age", example = "25")
    private Integer age;

    // Default constructor
    public UserDTO() {
    }

    public UserDTO(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
