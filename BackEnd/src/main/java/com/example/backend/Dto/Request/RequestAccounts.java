package com.example.backend.Dto.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class RequestAccounts {
    @NotBlank(message = "USER_USERNAME_NOT_NULL")
    String userName;
    @NotBlank(message = "USER_PASSWORD_NOT_NULL")
    String passWord;
    @NotBlank(message = "USER_FULLNAME_NOT_NULL")
    String fullName;
    @Email(message = "USER_EMAIL_REQUIRED")
    @NotBlank(message = "USER_EMAIL_NOT_NULL")
    String email;
    String photo;

}
