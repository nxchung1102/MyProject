package com.example.backend.Controller;

import com.example.backend.Dto.Request.RequestCategories;
import com.example.backend.Dto.Response.ResponseApi;
import com.example.backend.Dto.Response.ResponseCategories;
import com.example.backend.Service.CategoriesService;
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
@RequestMapping("/api/category")
public class CategoriesController {
    CategoriesService service;

    @GetMapping
    public ResponseEntity<?> getList() {
        return ResponseEntity.ok(service.getList());
    }

    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam(defaultValue = "0", name = "page") Integer page) {
        return ResponseEntity.ok(service.getPage(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detail(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.detail(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNew(@RequestBody @Valid RequestCategories cate) {
        ResponseApi<ResponseCategories> api = new ResponseApi<>();
        api.setResult(service.addNew(cate));
        return ResponseEntity.ok(api);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateNew(@PathVariable("id") Integer id, @RequestBody @Valid RequestCategories cate) {
        ResponseApi<ResponseCategories> api = new ResponseApi<>();
        api.setResult(service.updateNew(id, cate));
        return ResponseEntity.ok(api);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
