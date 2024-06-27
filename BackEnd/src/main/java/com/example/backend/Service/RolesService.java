package com.example.backend.Service;

import com.example.backend.Dto.Request.RequestRoles;
import com.example.backend.Dto.Response.ResponseRoles;
import com.example.backend.Mapper.MapRoles;
import com.example.backend.Model.Roles;
import com.example.backend.Repositories.AuthoritiesDAO;
import com.example.backend.Repositories.RolesDAO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RolesService {

    RolesDAO dao;
    MapRoles mapRoles;
    AuthoritiesDAO authoritiesDAO;

    public List<ResponseRoles> getList() {
        return dao.findAll().stream().map(mapRoles::responseRoles).toList();
    }

    public Page<Roles> getPage(Integer num) {
        Pageable pageable = PageRequest.of(num, 10);
        return dao.findAll(pageable);
    }

    public ResponseRoles detail(String id) {
        return mapRoles.responseRoles(dao.findById(id)
                .orElseThrow(() -> new RuntimeException("id does not exist")));
    }

    public ResponseRoles addNew(RequestRoles role) {
//        System.out.println(role);
        Roles r = mapRoles.mapRoles(role);
        var author = authoritiesDAO.findAllById(role.getAuthorities());
        r.setAuthorities(new HashSet<>(author));
        System.out.println(author);
        dao.save(r);
        return mapRoles.responseRoles(r);
    }

    public ResponseRoles updateNew(String id, RequestRoles role) {
        Roles r = dao.findById(id)
                .orElseThrow(() -> new RuntimeException("id does not exist"));
        mapRoles.updateRoles(r, role);
        var author = authoritiesDAO.findAllById(role.getAuthorities());
        r.setAuthorities(new HashSet<>(author));
        return mapRoles.responseRoles(dao.save(r));
    }

    public ResponseRoles delete(String id) {

        return dao.findById(id).map(r -> {
            dao.deleteById(id);
            return mapRoles.responseRoles(r);
        }).orElse(null);
    }

}
