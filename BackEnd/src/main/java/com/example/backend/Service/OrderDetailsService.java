package com.example.backend.Service;

import com.example.backend.Dto.Request.RequestOrderDetails;
import com.example.backend.Dto.Response.ResponseOrderDetails;
import com.example.backend.Exception.ErrorCode;
import com.example.backend.Exception.GlobalException;
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

    public List<ResponseOrderDetails> getList() {
        return dao.findAll().stream().map(mapOrderDetails::responseOrderDetails).toList();
    }

    public Page<ResponseOrderDetails> getPage(Integer num) {
        Pageable pageable = PageRequest.of(num, 10);
        return (Page<ResponseOrderDetails>) dao.findAll(pageable).stream().map(mapOrderDetails::responseOrderDetails).toList();
    }

    public ResponseOrderDetails detail(Long id) {
        return mapOrderDetails.responseOrderDetails(dao.findById(id)
                .orElseThrow(() -> new GlobalException(ErrorCode.ORDER_DETAIL_NOT_EXIST)));
    }

    public ResponseOrderDetails addNew(RequestOrderDetails orderDetails) {
        OrderDetails o = dao.save(mapOrderDetails.mapOrderDetails(orderDetails));
        return mapOrderDetails.responseOrderDetails(o);
    }

    public ResponseOrderDetails updateNew(Long id, RequestOrderDetails orderDetails) {
        OrderDetails o = dao.findById(id)
                .orElseThrow(() -> new GlobalException(ErrorCode.ORDER_DETAIL_NOT_EXIST));
        mapOrderDetails.updateOrderDetails(o, orderDetails);
        return mapOrderDetails.responseOrderDetails(dao.save(o));
    }

    public ResponseOrderDetails delete(Long id) {
        return dao.findById(id).map(o -> {
            dao.deleteById(id);
            return mapOrderDetails.responseOrderDetails(o);
        }).orElseThrow(() -> new GlobalException(ErrorCode.ORDER_DETAIL_NOT_EXIST));
    }
}
