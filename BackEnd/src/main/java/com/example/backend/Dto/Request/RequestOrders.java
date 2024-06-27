package com.example.backend.Dto.Request;

import com.example.backend.Model.Accounts;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class RequestOrders {
    Accounts userName;
    @NotBlank(message = "ORDER_DATE_NOT_NULL")
    Date createDateOrder;
    @NotBlank(message = "ORDER_ADDRESS_NOT_NULL")
    String address;
}
