package com.example.backend.Controller;

import com.example.backend.Dto.Request.RequestOrderDetails;
import com.example.backend.Dto.Response.ResponseApi;
import com.example.backend.Dto.Response.ResponseOrderDetails;
import com.example.backend.Service.OrderDetailsService;
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
@RequestMapping("/api/order-detail")
public class OrderDetailsController {
    OrderDetailsService service;

    @GetMapping
    public ResponseApi<List<ResponseOrderDetails>> getList() {
        return ResponseApi.<List<ResponseOrderDetails>>builder()
                .result(service.getList())
                .build();
    }

    @GetMapping("/page")
    public ResponseApi<Page<ResponseOrderDetails>> getPage(@RequestParam(defaultValue = "0", name = "page") Integer page) {
        return ResponseApi.<Page<ResponseOrderDetails>>builder()
                .result(service.getPage(page))
                .build();
    }

    @GetMapping("/{id}")
    public ResponseApi<ResponseOrderDetails> detail(@PathVariable("id") Long id) {
        return ResponseApi.<ResponseOrderDetails>builder()
                .result(service.detail(id))
                .build();
    }

    @PostMapping("/add")
    public ResponseApi<ResponseOrderDetails> addNew(@RequestBody @Valid RequestOrderDetails od) {
        return ResponseApi.<ResponseOrderDetails>builder()
                .result(service.addNew(od))
                .build();
    }

    @PutMapping("/{id}")
    public ResponseApi<ResponseOrderDetails> updateNew(@PathVariable("id") Long id, @RequestBody @Valid RequestOrderDetails od) {
        return ResponseApi.<ResponseOrderDetails>builder()
                .result(service.updateNew(id, od))
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseApi<ResponseOrderDetails> delete(@PathVariable("id") Long id) {
        return ResponseApi.<ResponseOrderDetails>builder()
                .result(service.delete(id))
                .build();
    }
}
