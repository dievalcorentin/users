package com.graphmytech.administrationusers.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CreateUserDTO {
    @Schema(description = "User Name", example = "Toto")
    private String name;
    @Schema(description = "User Age", example = "25")
    private Integer age;
}
