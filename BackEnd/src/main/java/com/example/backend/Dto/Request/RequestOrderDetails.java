package com.example.backend.Dto.Request;

import com.example.backend.Model.Orders;
import com.example.backend.Model.Products;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class RequestOrderDetails {
    Orders orderId;
    Products productId;
    @NotNull(message = "ORDERDETAILS_PRICE_NOT_NULL")
    Double price;
    @NotNull(message = "ORDERDETAILS_QUANTITY_NOT_NULL")
    Integer quantity;
}
