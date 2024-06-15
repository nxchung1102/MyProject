package com.example.backend.Service;

import com.example.backend.Dto.Request.RequestCategories;
import com.example.backend.Dto.Response.ResponseCategories;
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

    public List<Categories> getList() {
        return dao.findAll();
    }

    public Page<Categories> getPage(Integer num) {
        Pageable pageable = PageRequest.of(num, 10);
        return dao.findAll(pageable);
    }

    public Categories detail(Integer id) {
        return dao.findById(id)
                .orElseThrow(() -> new RuntimeException("id does not exist"));
    }

    public ResponseCategories addNew(RequestCategories cate) {
        Categories c = dao.save(mapCategories.mapCategories(cate));
        return mapCategories.responseCategories(c);
    }

    public ResponseCategories updateNew(Integer id, RequestCategories cate) {
        Categories c = dao.findById(id)
                .orElseThrow(() -> new RuntimeException("id does not exist"));
        mapCategories.updateCategories(c, cate);
        return mapCategories.responseCategories(dao.save(c));
    }

    public Categories delete(Integer id) {
        return dao.findById(id).map(c -> {
            dao.delete(c);
            return c;
        }).orElse(null);
    }
}
