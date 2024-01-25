package com.graphmytech.administrationusers.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CreateUserDTO {
    @Schema(description = "User login/email", example = "toto@tata.com")
    private String email;
    @Schema(description = "User Password", example = "123Password456")
    private String password;

//    For now we imagine that it is not required at first,
//    and will be updated by the user by a update command
//    @Schema(description = "User first name", example = "Toto")
//    private String firstName;
//    @Schema(description = "User Last name", example = "Dupont")
//    private String lastName;

}
