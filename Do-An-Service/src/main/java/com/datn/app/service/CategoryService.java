package com.datn.app.service;

import com.datn.app.dao.idao.CategoryDao;
import com.datn.app.dto.CategoryDto;
import com.datn.app.dto.UserDto;
import com.datn.app.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private UserService userService;

    public List<CategoryDto> findAllParentByRole(HttpServletRequest request){
        UserDto userDto = userService.findByUsername(request.getUserPrincipal().getName());
        if (userDto != null) {
            List<CategoryDto> categoryDtoList = new ArrayList<>();
            List<Category> categories = categoryDao.findAllParentByRole(userDto.getRoleId());
            return convertCategoryDto(categoryDtoList, categories);
        }
        return null;
    }

    public List<CategoryDto> findAllChildByRoleAndParent(Long parentId, HttpServletRequest request){
        UserDto userDto = userService.findByUsername(request.getUserPrincipal().getName());
        if (userDto != null) {
            List<CategoryDto> categoryDtoList = new ArrayList<>();
            List<Category> categories = categoryDao.findAllChildByRoleAndParent(userDto.getRoleId(), parentId);
            return convertCategoryDto(categoryDtoList, categories);
        }
        return null;
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
