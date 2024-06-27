package com.example.backend.Dto.Request;

import com.example.backend.Model.Categories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class RequestProducts {
    @NotBlank(message = "PRODUCTS_NAME_NOT_NULL")
    String name;
    @NotBlank(message = "PRODUCTS_IMAGE_NOT_NULL")
    String image;
    @NotNull(message = "PRODUCTS_PRICE_NOT_NULL")
    Double price;
    @NotBlank(message = "PRODUCTS_DATE_NOT_NULL")
    Date createDateProduct;
    @NotNull(message = "PRODUCTS_AVAILABLE_NOT_NULL")
    Boolean available;
    Categories categoryId;
}
