package com.graphmytech.administrationusers.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CreateUserDTO {
    @Schema(name = "User Name", example = "Toto", required = true)
    private String name;
    @Schema(name = "User Age", example = "25", required = true)
    private Integer age;
}
