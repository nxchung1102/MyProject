package com.example.backend.Dto.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@ToString

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class RequestAccounts {
    @Email(message = "USER_EMAIL_REQUIRED")
    @NotBlank(message = "USER_EMAIL_NOT_NULL")
    String email;
    @NotBlank(message = "USER_PASSWORD_NOT_NULL")
    String passWord;
    @NotBlank(message = "USER_FULLNAME_NOT_NULL")
    String fullName;
    String photo;
    Set<String> roles;

}
