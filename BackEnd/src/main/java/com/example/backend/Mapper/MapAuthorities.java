package com.example.backend.Mapper;


import com.example.backend.Dto.Request.RequestAuthorities;
import com.example.backend.Dto.Response.ResponseAuthorities;
import com.example.backend.Model.Authorities;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MapAuthorities {
    Authorities mapAuthorities(RequestAuthorities request);

    ResponseAuthorities responseAuthorities(Authorities authorities);

    void updateAuthorities(@MappingTarget Authorities authorities, RequestAuthorities request);
}
