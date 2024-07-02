package com.example.backend.Controller;

import com.example.backend.Dto.Request.RequestAccounts;
import com.example.backend.Dto.Response.ResponseAccounts;
import com.example.backend.Dto.Response.ResponseApi;
import com.example.backend.Service.AccountsService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@CrossOrigin("*")
@RequestMapping("/api/account")
public class AccountsController {

    AccountsService service;

    @GetMapping
    public ResponseApi<List<ResponseAccounts>> getList() {
        return ResponseApi.<List<ResponseAccounts>>builder()
                .result(service.getList())
                .build();
    }

    @GetMapping("/page")
    public ResponseApi<Page<ResponseAccounts>> getPage(@RequestParam(defaultValue = "0", name = "page") Integer page) {
        return ResponseApi.<Page<ResponseAccounts>>builder()
                .result(service.getPage(page))
                .build();
    }

    @GetMapping("/{username}")
    public ResponseApi<ResponseAccounts> detail(@PathVariable("username") String username) {
        return ResponseApi.<ResponseAccounts>builder()
                .result(service.detail(username))
                .build();
    }

    @GetMapping("/info")
    public ResponseApi<ResponseAccounts> getInfo() {
        return ResponseApi.<ResponseAccounts>builder()
                .result(service.getInfo())
                .build();
    }

    @PostMapping("/add")
    public ResponseApi<ResponseAccounts> addNew(@RequestBody @Valid RequestAccounts acc) {
        return ResponseApi.<ResponseAccounts>builder()
                .result(service.addNew(acc))
                .build();
    }

    @PutMapping("/{username}")
    public ResponseApi<ResponseAccounts> updateNew(@PathVariable("username") String username, @RequestBody @Valid RequestAccounts acc) {
        return ResponseApi.<ResponseAccounts>builder()
                .result(service.updateNew(username, acc))
                .build();
    }

    @DeleteMapping("/{username}")
    public ResponseApi<ResponseAccounts> delete(@PathVariable("username") String username) {
        return ResponseApi.<ResponseAccounts>builder()
                .result(service.delete(username))
                .build();
    }
}
