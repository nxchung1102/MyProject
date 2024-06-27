package com.example.backend.Mapper;

import com.example.backend.Dto.Request.RequestRoles;
import com.example.backend.Dto.Response.ResponseRoles;
import com.example.backend.Model.Roles;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MapRoles {
    @Mapping(target = "authorities", ignore = true)
    Roles mapRoles(RequestRoles request);

    ResponseRoles responseRoles(Roles roles);

    @Mapping(target = "authorities", ignore = true)
    void updateRoles(@MappingTarget Roles roles, RequestRoles request);
}
