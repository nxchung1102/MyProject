package com.example.backend.Mapper;


import com.example.backend.Dto.Request.RequestAccounts;
import com.example.backend.Dto.Response.ResponseAccounts;
import com.example.backend.Model.Accounts;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface MapAccounts {
    Accounts mapAccounts(RequestAccounts request);

    ResponseAccounts responseAccounts(Accounts accounts);

    void updateAccounts(@MappingTarget Accounts accounts, RequestAccounts request);
}
