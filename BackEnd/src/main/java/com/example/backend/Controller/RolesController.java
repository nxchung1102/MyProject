package com.example.backend.Controller;

import com.example.backend.Dto.Request.RequestRoles;
import com.example.backend.Dto.Response.ResponseApi;
import com.example.backend.Dto.Response.ResponseRoles;
import com.example.backend.Service.RolesService;
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
@RequestMapping("/api/role")
public class RolesController {
    RolesService service;

    @GetMapping
    public ResponseApi<List<ResponseRoles>> getList() {
        return ResponseApi.<List<ResponseRoles>>builder()
                .result(service.getList())
                .build();
    }

    @GetMapping("/page")
    public ResponseApi<Page<ResponseRoles>> getPage(@RequestParam(defaultValue = "0", name = "page") Integer page) {
        return ResponseApi.<Page<ResponseRoles>>builder()
                .result(service.getPage(page))
                .build();
    }

    @GetMapping("/{id}")
    public ResponseApi<ResponseRoles> detail(@PathVariable("id") String id) {
        return ResponseApi.<ResponseRoles>builder()
                .result(service.detail(id))
                .build();
    }

    @PostMapping("/add")
    public ResponseApi<ResponseRoles> addNew(@RequestBody @Valid RequestRoles r) {
        return ResponseApi.<ResponseRoles>builder()
                .result(service.addNew(r))
                .build();
    }

    @PutMapping("/{id}")
    public ResponseApi<ResponseRoles> updateNew(@PathVariable("id") String id, @RequestBody @Valid RequestRoles r) {
        return ResponseApi.<ResponseRoles>builder()
                .result(service.updateNew(id, r))
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseApi<ResponseRoles> delete(@PathVariable("id") String id) {
        return ResponseApi.<ResponseRoles>builder()
                .result(service.delete(id))
                .build();
    }
}
