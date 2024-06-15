package com.example.backend.Dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class RequestRoles {
    @NotBlank(message = "ROLES_NAME_NOT_NULL")
    String name;
}
