package com.example.backend.Service;

import com.example.backend.Dto.Request.RequestAuthorities;
import com.example.backend.Dto.Response.ResponseAuthorities;
import com.example.backend.Mapper.MapAuthorities;
import com.example.backend.Model.Authorities;
import com.example.backend.Repositories.AuthoritiesDAO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthoritiesService {
    AuthoritiesDAO dao;
    MapAuthorities mapAuthorities;

    public List<ResponseAuthorities> getList() {
        return dao.findAll().stream().map(mapAuthorities::responseAuthorities).toList();
    }

    public Page<Authorities> getPage(Integer num) {
        Pageable pageable = PageRequest.of(num, 10);
        return dao.findAll(pageable);
    }

    public ResponseAuthorities detail(String name) {
        return mapAuthorities.responseAuthorities(dao.findById(name)
                .orElseThrow(() -> new RuntimeException("name does not exist")));
    }

    public ResponseAuthorities addNew(RequestAuthorities auth) {
        Authorities a = dao.save(mapAuthorities.mapAuthorities(auth));
        return mapAuthorities.responseAuthorities(a);
    }

    public ResponseAuthorities updateNew(String name, RequestAuthorities auth) {
        Authorities a = dao.findById(name)
                .orElseThrow(() -> new RuntimeException("name does not exist"));
        mapAuthorities.updateAuthorities(a, auth);
        return mapAuthorities.responseAuthorities(dao.save(a));
    }

    public ResponseAuthorities delete(String name) {
        return dao.findById(name).map(au -> {
            dao.deleteById(name);
            return mapAuthorities.responseAuthorities(au);
        }).orElse(null);
    }
}
