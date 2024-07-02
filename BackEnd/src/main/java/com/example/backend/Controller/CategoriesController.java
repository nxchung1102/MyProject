package com.example.backend.Controller;

import com.example.backend.Dto.Request.RequestCategories;
import com.example.backend.Dto.Response.ResponseApi;
import com.example.backend.Dto.Response.ResponseCategories;
import com.example.backend.Service.CategoriesService;
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
@RequestMapping("/api/category")
public class CategoriesController {
    CategoriesService service;

    @GetMapping
    public ResponseApi<List<ResponseCategories>> getList() {
        return ResponseApi.<List<ResponseCategories>>builder()
                .result(service.getList())
                .build();
    }

    @GetMapping("/page")
    public ResponseApi<Page<ResponseCategories>> getPage(@RequestParam(defaultValue = "0", name = "page") Integer page) {
        return ResponseApi.<Page<ResponseCategories>>builder()
                .result(service.getPage(page))
                .build();
    }

    @GetMapping("/{id}")
    public ResponseApi<ResponseCategories> detail(@PathVariable("id") Integer id) {
        return ResponseApi.<ResponseCategories>builder()
                .result(service.detail(id))
                .build();
    }

    @PostMapping("/add")
    public ResponseApi<ResponseCategories> addNew(@RequestBody @Valid RequestCategories cate) {
        return ResponseApi.<ResponseCategories>builder()
                .result(service.addNew(cate))
                .build();
    }

    @PutMapping("/{id}")
    public ResponseApi<ResponseCategories> updateNew(@PathVariable("id") Integer id, @RequestBody @Valid RequestCategories cate) {
        return ResponseApi.<ResponseCategories>builder()
                .result(service.updateNew(id, cate))
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseApi<ResponseCategories> delete(@PathVariable("id") Integer id) {
        return ResponseApi.<ResponseCategories>builder()
                .result(service.delete(id))
                .build();
    }
}
