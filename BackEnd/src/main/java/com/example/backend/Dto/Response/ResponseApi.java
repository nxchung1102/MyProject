package com.example.backend.Dto.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseApi<T> {
    private int status;
    private String message;
    private T result;
}
