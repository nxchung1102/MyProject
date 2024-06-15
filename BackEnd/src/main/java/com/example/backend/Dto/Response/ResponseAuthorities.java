package com.example.backend.Dto.Response;

import com.example.backend.Model.Accounts;
import com.example.backend.Model.Roles;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ResponseAuthorities {
    Integer id;
    Accounts userName;
    Roles roleId;
}
