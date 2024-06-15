package com.example.backend.Controller;

import com.example.backend.Dto.Request.RequestRoles;
import com.example.backend.Dto.Response.ResponseApi;
import com.example.backend.Dto.Response.ResponseRoles;
import com.example.backend.Service.RolesService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@CrossOrigin("*")
@RequestMapping("/api/role")
public class RolesController {
    RolesService service;

    @GetMapping
    public ResponseEntity<?> getList() {
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
    public ResponseEntity<?> addNew(@RequestBody @Valid RequestRoles r) {
        ResponseApi<ResponseRoles> api = new ResponseApi<>();
        api.setResult(service.addNew(r));
        return ResponseEntity.ok(api);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateNew(@PathVariable("id") String id, @RequestBody @Valid RequestRoles r) {
        ResponseApi<ResponseRoles> api = new ResponseApi<>();
        api.setResult(service.updateNew(id, r));
        return ResponseEntity.ok(api);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
