package com.example.backend.Dto.Request;

import com.example.backend.Model.Accounts;
import com.example.backend.Model.Roles;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class RequestAuthorities {
    Accounts userName;
    Roles roleId;
}
