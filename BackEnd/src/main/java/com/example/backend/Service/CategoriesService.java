package com.example.backend.Service;

import com.example.backend.Dto.Request.RequestCategories;
import com.example.backend.Dto.Response.ResponseCategories;
import com.example.backend.Exception.ErrorCode;
import com.example.backend.Exception.GlobalException;
import com.example.backend.Mapper.MapCategories;
import com.example.backend.Model.Categories;
import com.example.backend.Repositories.CategoriesDAO;
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
public class CategoriesService {
    MapCategories mapCategories;
    CategoriesDAO dao;

    public List<ResponseCategories> getList() {
        return dao.findAll().stream().map(mapCategories::responseCategories).toList();
    }

    public Page<ResponseCategories> getPage(Integer num) {
        Pageable pageable = PageRequest.of(num, 10);
        return (Page<ResponseCategories>) dao.findAll(pageable).stream().map(mapCategories::responseCategories).toList();
    }

    public ResponseCategories detail(Integer id) {
        return mapCategories.responseCategories(dao.findById(id)
                .orElseThrow(() -> new GlobalException(ErrorCode.CATE_NOT_EXIST)));
    }

    public ResponseCategories addNew(RequestCategories cate) {
        Categories c = dao.save(mapCategories.mapCategories(cate));
        return mapCategories.responseCategories(c);
    }

    public ResponseCategories updateNew(Integer id, RequestCategories cate) {
        Categories c = dao.findById(id)
                .orElseThrow(() -> new GlobalException(ErrorCode.CATE_NOT_EXIST));
        mapCategories.updateCategories(c, cate);
        return mapCategories.responseCategories(dao.save(c));
    }

    public ResponseCategories delete(Integer id) {
        return dao.findById(id).map(c -> {
            dao.delete(c);
            return mapCategories.responseCategories(c);
        }).orElseThrow(() -> new GlobalException(ErrorCode.CATE_NOT_EXIST));
    }
}
