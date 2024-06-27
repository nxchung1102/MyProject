package com.example.backend.Mapper;


import com.example.backend.Dto.Request.RequestAccounts;
import com.example.backend.Dto.Response.ResponseAccounts;
import com.example.backend.Model.Accounts;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface MapAccounts {
    @Mapping(target = "roles", ignore = true)
    Accounts mapAccounts(RequestAccounts request);

    ResponseAccounts responseAccounts(Accounts accounts);

    @Mapping(target = "roles", ignore = true)
    void updateAccounts(@MappingTarget Accounts accounts, RequestAccounts request);
}
