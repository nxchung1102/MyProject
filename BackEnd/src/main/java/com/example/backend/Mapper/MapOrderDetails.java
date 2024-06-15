package com.example.backend.Mapper;


import com.example.backend.Dto.Request.RequestOrderDetails;
import com.example.backend.Dto.Response.ResponseOrderDetails;
import com.example.backend.Model.OrderDetails;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MapOrderDetails {
    OrderDetails mapOrderDetails(RequestOrderDetails request);

    ResponseOrderDetails responseOrderDetails(OrderDetails orderDetails);

    void updateOrderDetails(@MappingTarget OrderDetails orderDetails, RequestOrderDetails request);
}
