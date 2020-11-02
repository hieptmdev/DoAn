package com.datn.app.dao.idao;

import com.datn.app.dao.crud.CrudCategoryDao;
import com.datn.app.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Long> , CrudCategoryDao {
}
