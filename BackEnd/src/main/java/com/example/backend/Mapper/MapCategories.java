package com.example.backend.Mapper;


import com.example.backend.Dto.Request.RequestCategories;
import com.example.backend.Dto.Response.ResponseCategories;
import com.example.backend.Model.Categories;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MapCategories {

    Categories mapCategories(RequestCategories request);

    ResponseCategories responseCategories(Categories categories);

    void updateCategories(@MappingTarget Categories categories, RequestCategories request);
}
