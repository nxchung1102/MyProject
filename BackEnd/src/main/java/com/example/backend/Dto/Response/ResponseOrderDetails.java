package com.example.backend.Dto.Response;

import com.example.backend.Model.Orders;
import com.example.backend.Model.Products;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ResponseOrderDetails {
    Long id;
    Orders orderId;
    Products productId;
    Double price;
    Integer quantity;
}
