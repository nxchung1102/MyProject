package com.example.backend.Controller;

import com.example.backend.Dto.Request.RequestOrders;
import com.example.backend.Dto.Response.ResponseApi;
import com.example.backend.Dto.Response.ResponseOrders;
import com.example.backend.Service.OrdersService;
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
@RequestMapping("/api/order")
public class OrdersController {
    OrdersService service;

    @GetMapping
    public ResponseApi<List<ResponseOrders>> getList() {
        return ResponseApi.<List<ResponseOrders>>builder()
                .result(service.getList())
                .build();
    }

    @GetMapping("/page")
    public ResponseApi<Page<ResponseOrders>> getPage(@RequestParam(defaultValue = "0", name = "page") Integer page) {
        return ResponseApi.<Page<ResponseOrders>>builder()
                .result(service.getPage(page))
                .build();
    }

    @GetMapping("/{id}")
    public ResponseApi<ResponseOrders> detail(@PathVariable("id") Long id) {
        return ResponseApi.<ResponseOrders>builder()
                .result(service.detail(id))
                .build();
    }

    @PostMapping("/add")
    public ResponseApi<ResponseOrders> addNew(@RequestBody @Valid RequestOrders o) {
        return ResponseApi.<ResponseOrders>builder()
                .result(service.addNew(o))
                .build();
    }

    @PutMapping("/{id}")
    public ResponseApi<ResponseOrders> updateNew(@PathVariable("id") Long id, @RequestBody @Valid RequestOrders o) {
        return ResponseApi.<ResponseOrders>builder()
                .result(service.updateNew(id, o))
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseApi<ResponseOrders> delete(@PathVariable("id") Long id) {
        return ResponseApi.<ResponseOrders>builder()
                .result(service.delete(id))
                .build();
    }
}
