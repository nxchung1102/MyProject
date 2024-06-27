package com.example.backend.Dto.Response;

import com.example.backend.Model.Authorities;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@Builder
@ToString
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ResponseRoles {
    String name;
    String description;
    Set<Authorities> authorities;
}
