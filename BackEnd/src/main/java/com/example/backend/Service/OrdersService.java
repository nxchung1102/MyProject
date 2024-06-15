package com.example.backend.Service;

import com.example.backend.Dto.Request.RequestOrders;
import com.example.backend.Dto.Response.ResponseOrders;
import com.example.backend.Mapper.MapOrders;
import com.example.backend.Model.Orders;
import com.example.backend.Repositories.OrdersDAO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrdersService {
    MapOrders mapOrders;
    OrdersDAO dao;

    public List<Orders> getList() {
        return dao.findAll();
    }

    public Page<Orders> getPage(Integer num) {
        Pageable pageable = PageRequest.of(num, 10);
        return dao.findAll(pageable);
    }

    public Orders detail(Long id) {
        return dao.findById(id)
                .orElseThrow(() -> new RuntimeException("id does not exist"));
    }

    public ResponseOrders addNew(RequestOrders orders) {
        Orders o = mapOrders.mapOrders(orders);
        return mapOrders.responseOrders(dao.save(o));
    }

    public ResponseOrders updateNew(Long id, RequestOrders orders) {
        Orders o = dao.findById(id)
                .orElseThrow(() -> new RuntimeException("id does not exist"));
        mapOrders.updateOrders(o, orders);
        return mapOrders.responseOrders(dao.save(o));
    }

    public Orders delete(Long id) {
        return dao.findById(id).map(o -> {
            dao.deleteById(id);
            return o;
        }).orElse(null);
    }
}
