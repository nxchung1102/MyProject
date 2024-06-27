package com.example.backend.Dto.Response;

import com.example.backend.Model.Categories;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ResponseProducts {
    Integer id;
    String name;
    String image;
    Double price;
    Date createDateProduct;
    Boolean available;
    Categories categoryId;
}
