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

    public List<CategoryDto> findAllParentByRole(Long roleId){
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        List<Category> categories = categoryDao.findAllParentByRole(roleId);
        return convertCategoryDto(categoryDtoList, categories);
    }

    public List<CategoryDto> findAllChildByRoleAndParent(Long roleId, Long parentId){
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        List<Category> categories = categoryDao.findAllChildByRoleAndParent(roleId, parentId);
        return convertCategoryDto(categoryDtoList, categories);
    }

    private List<CategoryDto> convertCategoryDto(List<CategoryDto> categoryDtoList, List<Category> categories) {
        if (categories != null && !categories.isEmpty()){
            categories.forEach(c -> {
                CategoryDto dto = c.convertToDto();
                categoryDtoList.add(dto);
            });
        }
        return categoryDtoList;
    }
}
