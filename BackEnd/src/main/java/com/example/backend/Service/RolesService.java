package com.example.backend.Service;

import com.example.backend.Dto.Request.RequestRoles;
import com.example.backend.Dto.Response.ResponseRoles;
import com.example.backend.Mapper.MapRoles;
import com.example.backend.Model.Roles;
import com.example.backend.Repositories.RolesDAO;
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
public class RolesService {

    RolesDAO dao;
    MapRoles mapRoles;

    public List<Roles> getList() {
        return dao.findAll();
    }

    public Page<Roles> getPage(Integer num) {
        Pageable pageable = PageRequest.of(num, 10);
        return dao.findAll(pageable);
    }

    public Roles detail(String id) {
        return dao.findById(id)
                .orElseThrow(() -> new RuntimeException("id does not exist"));
    }

    public ResponseRoles addNew(RequestRoles role) {
        Roles r = mapRoles.mapRoles(role);

        return mapRoles.responseRoles(dao.save(r));
    }

    public ResponseRoles updateNew(String id, RequestRoles role) {
        Roles r = dao.findById(id)
                .orElseThrow(() -> new RuntimeException("id does not exist"));
        mapRoles.updateRoles(r, role);

        return mapRoles.responseRoles(dao.save(r));
    }

    public Roles delete(String id) {

        return dao.findById(id).map(r -> {
            dao.deleteById(id);
            return r;
        }).orElse(null);
    }

}
