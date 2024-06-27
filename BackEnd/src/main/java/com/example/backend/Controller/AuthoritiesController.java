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
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
@CrossOrigin("*")
@RequestMapping("/api/authority")
public class AuthoritiesController {
    AuthoritiesService service;

    @GetMapping
    public ResponseEntity<?> getList() throws Exception {
        var authen = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("name: " + authen.getName());
        System.out.println("name: " + authen.getAuthorities());
        return ResponseEntity.ok(service.getList());
    }

    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam(defaultValue = "0", name = "page") Integer page) {
        return ResponseEntity.ok(service.getPage(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detail(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.detail(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNew(@RequestBody @Valid RequestAuthorities auth) {
        ResponseApi<ResponseAuthorities> api = new ResponseApi<>();
        api.setResult(service.addNew(auth));
        return ResponseEntity.ok(api);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateNew(@PathVariable("id") String id, @RequestBody @Valid RequestAuthorities auth) {
        ResponseApi<ResponseAuthorities> api = new ResponseApi<>();
        api.setResult(service.updateNew(id, auth));
        return ResponseEntity.ok(api);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
