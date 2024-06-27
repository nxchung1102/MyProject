package com.example.backend.Controller;

import com.example.backend.Dto.Request.RequestAccounts;
import com.example.backend.Dto.Response.ResponseAccounts;
import com.example.backend.Dto.Response.ResponseApi;
import com.example.backend.Service.AccountsService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
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
    public ResponseApi<?> getList() {
        return ResponseApi.<List<ResponseAccounts>>builder()
                .result(service.getList())
                .build();
    }

    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam(defaultValue = "0", name = "page") Integer page) {
        return ResponseEntity.ok(service.getPage(page));
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> detail(@PathVariable("username") String username) {
        return ResponseEntity.ok(service.detail(username));
    }

    @GetMapping("/info")
    public ResponseEntity<?> getInfo() {
        return ResponseEntity.ok(service.getInfo());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNew(@RequestBody @Valid RequestAccounts acc) {
        ResponseApi<ResponseAccounts> api = new ResponseApi<>();
        api.setResult(service.addNew(acc));
        return ResponseEntity.ok(api);
    }

    @PutMapping("/update/{username}")
    public ResponseEntity<?> updateNew(@PathVariable("username") String username, @RequestBody @Valid RequestAccounts acc) {
        ResponseApi<ResponseAccounts> api = new ResponseApi<>();
        api.setResult(service.updateNew(username, acc));
        return ResponseEntity.ok(api);
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<?> delete(@PathVariable("username") String username) {
        return ResponseEntity.ok(service.delete(username));
    }
}
