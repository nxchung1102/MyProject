package com.example.backend.Service;

import com.example.backend.Dto.Request.RequestAccounts;
import com.example.backend.Dto.Response.ResponseAccounts;
import com.example.backend.Exception.ErrorCode;
import com.example.backend.Exception.GlobalException;
import com.example.backend.Mapper.MapAccounts;
import com.example.backend.Model.Accounts;
import com.example.backend.Repositories.AccountsDAO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountsService {
    AccountsDAO dao;
    MapAccounts mapAccounts;
    PasswordEncoder passwordEncoder;

    public List<Accounts> getList() {
        return dao.findAll();
    }

    public Page<Accounts> getPage(Integer num) {
        Pageable pageable = PageRequest.of(num, 10);
        return dao.findAll(pageable);
    }

    public Accounts detail(String username) {
        return dao.findById(username).orElseThrow(() -> new GlobalException(ErrorCode.USER_EXISTED));
    }

    public ResponseAccounts addNew(RequestAccounts acc) {
        if (dao.existsAccountsByUserName(acc.getUserName())) {
            throw new RuntimeException("username existes");
        }
        Accounts a = mapAccounts.mapAccounts(acc);

        a.setPassWord(passwordEncoder.encode(acc.getPassWord()));
        return mapAccounts.responseAccounts(dao.save(a));
    }

    public ResponseAccounts updateNew(String username, RequestAccounts acc) {
        Accounts a = dao.findById(username).orElseThrow(() -> new RuntimeException("username does not exist"));
        mapAccounts.updateAccounts(a, acc);
        return mapAccounts.responseAccounts(dao.save(a));

    }

    public Accounts delete(String username) {
        return dao.findById(username).map(a -> {
            dao.deleteById(username);
            return a;
        }).orElse(null);
    }
}
