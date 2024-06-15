package com.example.backend.Mapper;


import com.example.backend.Dto.Request.RequestProducts;
import com.example.backend.Dto.Response.ResponseProducts;
import com.example.backend.Model.Products;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MapProducts {
    Products mapProducts(RequestProducts request);

    ResponseProducts responseProducts(Products products);

    void updateProducts(@MappingTarget Products products, RequestProducts request);
}
