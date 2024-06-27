package com.example.backend.Dto.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@ToString
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ResponseVerify {
    Boolean verify;
}
