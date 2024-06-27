package com.example.backend.Dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class RequestCategories {
    @NotBlank(message = "CATEGORIES_NAME_NOT_NULL")
    String name;


}
