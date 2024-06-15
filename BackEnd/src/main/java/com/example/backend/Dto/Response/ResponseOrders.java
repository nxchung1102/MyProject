package com.example.backend.Dto.Response;

import com.example.backend.Model.Accounts;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ResponseOrders {
    Long id;
    Accounts userName;
    Date createDateOrder;
    String address;
}
