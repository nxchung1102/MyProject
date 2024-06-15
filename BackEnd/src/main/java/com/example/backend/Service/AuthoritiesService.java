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

    public List<Authorities> getList() {
        return dao.findAll();
    }

    public Page<Authorities> getPage(Integer num) {
        Pageable pageable = PageRequest.of(num, 10);
        return dao.findAll(pageable);
    }

    public Authorities detail(Integer id) {
        return dao.findById(id)
                .orElseThrow(() -> new RuntimeException("id does not exist"));
    }

    public ResponseAuthorities addNew(RequestAuthorities auth) {
        Authorities a = dao.save(mapAuthorities.mapAuthorities(auth));
        return mapAuthorities.responseAuthorities(a);
    }

    public ResponseAuthorities updateNew(Integer id, RequestAuthorities auth) {
        Authorities a = dao.findById(id)
                .orElseThrow(() -> new RuntimeException("id does not exist"));
        mapAuthorities.updateAuthorities(a, auth);
        return mapAuthorities.responseAuthorities(dao.save(a));
    }

    public Authorities delete(Integer id) {
        return dao.findById(id).map(au -> {
            dao.deleteById(id);
            return au;
        }).orElse(null);
    }
}
