package com.datn.app.dao.crud;

import com.datn.app.entity.Category;

import java.util.List;

public interface CrudCategoryDao {
    List<Category> findAllParentByRole(Long roleId);

    List<Category> findAllChildByRoleAndParent(Long roleId, Long parentId);
}
