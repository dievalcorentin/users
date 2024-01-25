package com.graphmytech.administrationusers.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
    @Schema(description = "User login/email", example = "toto@tata.com")
    private String email;
    @Schema(description = "User Password", example = "123Password456")
    private String password;
    @Schema(description = "User first name", example = "Toto")
    private String firstName;
    @Schema(description = "User Last name", example = "Dupont")
    private String lastName;

    // Default constructor
    public UserDTO() {
    }

    public UserDTO(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
