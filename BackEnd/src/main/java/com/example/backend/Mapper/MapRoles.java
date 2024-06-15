package com.example.backend.Mapper;

import com.example.backend.Dto.Request.RequestRoles;
import com.example.backend.Dto.Response.ResponseRoles;
import com.example.backend.Model.Roles;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MapRoles {
    Roles mapRoles(RequestRoles request);

    ResponseRoles responseRoles(Roles roles);

    void updateRoles(@MappingTarget Roles roles, RequestRoles request);
}
