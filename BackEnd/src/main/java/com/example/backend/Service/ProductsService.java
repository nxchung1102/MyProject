package com.example.backend.Service;

import com.example.backend.Dto.Request.RequestProducts;
import com.example.backend.Dto.Response.ResponseProducts;
import com.example.backend.Exception.ErrorCode;
import com.example.backend.Exception.GlobalException;
import com.example.backend.Mapper.MapProducts;
import com.example.backend.Model.Products;
import com.example.backend.Repositories.ProductsDAO;
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
public class ProductsService {
    MapProducts mapProducts;
    ProductsDAO dao;

    public List<ResponseProducts> getList() {
        return dao.findAll().stream().map(mapProducts::responseProducts).toList();
    }

    public Page<ResponseProducts> getPage(Integer num) {
        Pageable pageable = PageRequest.of(num, 10);
        return (Page<ResponseProducts>) dao.findAll(pageable).stream().map(mapProducts::responseProducts).toList();
    }

    public ResponseProducts detail(Integer id) {
        return mapProducts.responseProducts(dao.findById(id)
                .orElseThrow(() -> new GlobalException(ErrorCode.PRODUCT_NOT_EXIST)));
    }

    public ResponseProducts addNew(RequestProducts prd) {
        Products p = mapProducts.mapProducts(prd);

        return mapProducts.responseProducts(dao.save(p));
    }

    public ResponseProducts updateNew(Integer id, RequestProducts prd) {
        Products p = dao.findById(id)
                .orElseThrow(() -> new GlobalException(ErrorCode.PRODUCT_NOT_EXIST));
        mapProducts.updateProducts(p, prd);
        return mapProducts.responseProducts(dao.save(p));
    }

    public ResponseProducts delete(Integer id) {

        return dao.findById(id).map(p -> {
            dao.deleteById(id);
            return mapProducts.responseProducts(p);
        }).orElseThrow(() -> new GlobalException(ErrorCode.PRODUCT_NOT_EXIST));
    }
}
