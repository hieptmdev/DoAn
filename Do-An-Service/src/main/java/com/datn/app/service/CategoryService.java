package com.datn.app.service;

import com.datn.app.dao.idao.CategoryDao;
import com.datn.app.dto.CategoryDto;
import com.datn.app.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    public List<CategoryDto> findAllByRole(Long roleId){
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        List<Category> categories = categoryDao.findAllByRole(roleId);
        if (categories != null && !categories.isEmpty()){
            categories.forEach(c -> {
                CategoryDto dto = c.convertToDto();
                dto.setCategoryParentId(c.getCategoryParent() != null ? c.getCategoryParent().getId() : null);
                categoryDtoList.add(dto);
            });
        }
        return categoryDtoList;
    }
}
