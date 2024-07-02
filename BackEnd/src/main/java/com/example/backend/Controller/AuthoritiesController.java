package com.example.backend.Controller;

import com.example.backend.Dto.Request.RequestAuthorities;
import com.example.backend.Dto.Response.ResponseApi;
import com.example.backend.Dto.Response.ResponseAuthorities;
import com.example.backend.Service.AuthoritiesService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
@CrossOrigin("*")
@RequestMapping("/api/authority")
public class AuthoritiesController {
    AuthoritiesService service;

    @GetMapping
    public ResponseApi<List<ResponseAuthorities>> getList() throws Exception {
        return ResponseApi.<List<ResponseAuthorities>>builder()
                .result(service.getList())
                .build();
    }

    @GetMapping("/page")
    public ResponseApi<Page<ResponseAuthorities>> getPage(@RequestParam(defaultValue = "0", name = "page") Integer page) {
        return ResponseApi.<Page<ResponseAuthorities>>builder()
                .result(service.getPage(page))
                .build();
    }

    @GetMapping("/{id}")
    public ResponseApi<ResponseAuthorities> detail(@PathVariable("id") String id) {
        return ResponseApi.<ResponseAuthorities>builder()
                .result(service.detail(id))
                .build();
    }

    @PostMapping("/add")
    public ResponseApi<ResponseAuthorities> addNew(@RequestBody @Valid RequestAuthorities auth) {
        return ResponseApi.<ResponseAuthorities>builder()
                .result(service.addNew(auth))
                .build();
    }

    @PutMapping("/{id}")
    public ResponseApi<ResponseAuthorities> updateNew(@PathVariable("id") String id, @RequestBody @Valid RequestAuthorities auth) {
        return ResponseApi.<ResponseAuthorities>builder()
                .result(service.updateNew(id, auth))
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseApi<ResponseAuthorities> delete(@PathVariable("id") String id) {
        return ResponseApi.<ResponseAuthorities>builder()
                .result(service.delete(id))
                .build();
    }
}
