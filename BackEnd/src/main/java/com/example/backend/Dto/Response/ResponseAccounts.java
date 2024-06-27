package com.example.backend.Dto.Response;

import com.example.backend.Model.Roles;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ResponseAccounts {
    String fullName;
    String email;
    String photo;
    Set<Roles> roles;
}
