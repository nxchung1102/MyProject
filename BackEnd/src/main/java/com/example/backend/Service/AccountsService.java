package com.example.backend.Service;

import com.example.backend.Dto.Request.RequestAccounts;
import com.example.backend.Dto.Response.ResponseAccounts;
import com.example.backend.Exception.ErrorCode;
import com.example.backend.Exception.GlobalException;
import com.example.backend.Mapper.MapAccounts;
import com.example.backend.Model.Accounts;
import com.example.backend.Repositories.AccountsDAO;
import com.example.backend.Repositories.RolesDAO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountsService {
    AccountsDAO dao;
    MapAccounts mapAccounts;
    RolesDAO rolesDAO;
    PasswordEncoder passwordEncoder;

    public List<ResponseAccounts> getList() {
        return dao.findAll().stream().map(mapAccounts::responseAccounts).toList();
    }

    public Page<ResponseAccounts> getPage(Integer num) {
        Pageable pageable = PageRequest.of(num, 10);
        return (Page<ResponseAccounts>) dao.findAll(pageable).stream().map(mapAccounts::responseAccounts).toList();
    }

    public ResponseAccounts detail(String username) {
        return mapAccounts.responseAccounts(dao.findById(username).orElseThrow(() -> new GlobalException(ErrorCode.USER_NOT_EXIST)));
    }

    public ResponseAccounts addNew(RequestAccounts acc) {
        if (dao.existsAccountsByEmail(acc.getEmail())) {
            throw new GlobalException(ErrorCode.USER_EXISTED);
        }
        Accounts a = mapAccounts.mapAccounts(acc);
        a.setPassWord(passwordEncoder.encode(acc.getPassWord()));
        var roles = rolesDAO.findAllById(acc.getRoles());
        a.setRoles(new HashSet<>(roles));
        return mapAccounts.responseAccounts(dao.save(a));
    }

    public ResponseAccounts updateNew(String username, RequestAccounts acc) {
        Accounts a = dao.findById(username).orElseThrow(() -> new GlobalException(ErrorCode.USER_NOT_EXIST));
        mapAccounts.updateAccounts(a, acc);
        a.setPassWord(passwordEncoder.encode(acc.getPassWord()));
        var roles = rolesDAO.findAllById(acc.getRoles());
        a.setRoles(new HashSet<>(roles));
        return mapAccounts.responseAccounts(dao.save(a));

    }

    public ResponseAccounts delete(String username) {
        return dao.findById(username).map(a -> {
            dao.deleteById(username);
            return mapAccounts.responseAccounts(a);
        }).orElseThrow(() -> new GlobalException(ErrorCode.USER_NOT_EXIST));
    }

    public ResponseAccounts getInfo() {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();
        var acc = dao.findByEmail(name).orElseThrow(
                () -> new GlobalException(ErrorCode.USER_NOT_EXIST)
        );
        return mapAccounts.responseAccounts(acc);
    }
}
