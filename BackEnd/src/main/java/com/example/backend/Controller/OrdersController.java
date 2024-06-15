package com.example.backend.Controller;

import com.example.backend.Dto.Request.RequestOrders;
import com.example.backend.Dto.Response.ResponseApi;
import com.example.backend.Dto.Response.ResponseOrders;
import com.example.backend.Service.OrdersService;
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
@RequestMapping("/api/order")
public class OrdersController {
    OrdersService service;

    @GetMapping
    public ResponseEntity<?> getList() {
        return ResponseEntity.ok(service.getList());
    }

    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam(defaultValue = "0", name = "page") Integer page) {
        return ResponseEntity.ok(service.getPage(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detail(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.detail(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNew(@RequestBody @Valid RequestOrders o) {
        ResponseApi<ResponseOrders> api = new ResponseApi<>();
        api.setResult(service.addNew(o));
        return ResponseEntity.ok(api);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateNew(@PathVariable("id") Long id, @RequestBody @Valid RequestOrders o) {
        ResponseApi<ResponseOrders> api = new ResponseApi<>();
        api.setResult(service.updateNew(id, o));
        return ResponseEntity.ok(api);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
