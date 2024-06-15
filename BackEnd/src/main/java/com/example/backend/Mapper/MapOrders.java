package com.example.backend.Mapper;


import com.example.backend.Dto.Request.RequestOrders;
import com.example.backend.Dto.Response.ResponseOrders;
import com.example.backend.Model.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MapOrders {
    Orders mapOrders(RequestOrders request);

    ResponseOrders responseOrders(Orders orders);

    void updateOrders(@MappingTarget Orders orders, RequestOrders request);
}
