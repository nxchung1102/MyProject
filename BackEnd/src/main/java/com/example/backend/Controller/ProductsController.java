package com.example.backend.Controller;

import com.example.backend.Dto.Request.RequestProducts;
import com.example.backend.Dto.Response.ResponseApi;
import com.example.backend.Dto.Response.ResponseProducts;
import com.example.backend.Service.ProductsService;
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
@RequestMapping("/api/product")
public class ProductsController {
    ProductsService service;

    @GetMapping
    public ResponseApi<List<ResponseProducts>> getList() {
        return ResponseApi.<List<ResponseProducts>>builder()
                .result(service.getList())
                .build();
    }

    @GetMapping("/page")
    public ResponseApi<Page<ResponseProducts>> getPage(@RequestParam(defaultValue = "0", name = "page") Integer page) {
        return ResponseApi.<Page<ResponseProducts>>builder()
                .result(service.getPage(page))
                .build();
    }

    @GetMapping("/{id}")
    public ResponseApi<ResponseProducts> detail(@PathVariable("id") Integer id) {
        return ResponseApi.<ResponseProducts>builder()
                .result(service.detail(id))
                .build();
    }

    @PostMapping("/add")
    public ResponseApi<ResponseProducts> addNew(@RequestBody @Valid RequestProducts prd) {
        return ResponseApi.<ResponseProducts>builder()
                .result(service.addNew(prd))
                .build();
    }

    @PutMapping("/{id}")
    public ResponseApi<ResponseProducts> updateNew(@PathVariable("id") Integer id, @RequestBody @Valid RequestProducts prd) {
        return ResponseApi.<ResponseProducts>builder()
                .result(service.updateNew(id, prd))
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseApi<ResponseProducts> delete(@PathVariable("id") Integer id) {
        return ResponseApi.<ResponseProducts>builder()
                .result(service.delete(id))
                .build();
    }
}
