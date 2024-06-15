package com.example.backend.Service;

import com.example.backend.Dto.Request.RequestOrderDetails;
import com.example.backend.Dto.Response.ResponseOrderDetails;
import com.example.backend.Mapper.MapOrderDetails;
import com.example.backend.Model.OrderDetails;
import com.example.backend.Repositories.OrderDetailsDAO;
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
public class OrderDetailsService {
    MapOrderDetails mapOrderDetails;
    OrderDetailsDAO dao;

    public List<OrderDetails> getList() {
        return dao.findAll();
    }

    public Page<OrderDetails> getPage(Integer num) {
        Pageable pageable = PageRequest.of(num, 10);
        return dao.findAll(pageable);
    }

    public OrderDetails detail(Long id) {
        return dao.findById(id)
                .orElseThrow(() -> new RuntimeException("id does not exist"));
    }

    public ResponseOrderDetails addNew(RequestOrderDetails orderDetails) {
        OrderDetails o = dao.save(mapOrderDetails.mapOrderDetails(orderDetails));
        return mapOrderDetails.responseOrderDetails(o);
    }

    public ResponseOrderDetails updateNew(Long id, RequestOrderDetails orderDetails) {
        OrderDetails o = dao.findById(id)
                .orElseThrow(() -> new RuntimeException("id does not exist"));
        mapOrderDetails.updateOrderDetails(o, orderDetails);
        return mapOrderDetails.responseOrderDetails(dao.save(o));
    }

    public OrderDetails delete(Long id) {
        return dao.findById(id).map(o -> {
            dao.deleteById(id);
            return o;
        }).orElse(null);
    }
}
