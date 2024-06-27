package com.example.backend.Dto.Request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class RequestRoles {
    String name;
    String description;
    Set<String> authorities;
}
