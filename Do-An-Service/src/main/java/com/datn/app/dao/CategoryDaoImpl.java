package com.datn.app.dao;

import com.datn.app.dao.crud.CrudCategoryDao;
import com.datn.app.entity.Category;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CategoryDaoImpl extends BaseDao<Category> implements CrudCategoryDao {
    public CategoryDaoImpl() {
        super(Category.class);
    }

    @Override
    public List<Category> findAllParentByRole(Long roleId) {
        String sql = "select c from Category c join Permission p on c.id=p.category.id where p.role.id=:roleId and c.categoryParentId is null";
        Query query = entityManager.createQuery(sql);
        query.setParameter("roleId", roleId);
        return query.getResultList();
    }

    @Override
    public List<Category> findAllChildByRoleAndParent(Long roleId, Long parentId) {
        String sql = "select c from Category c join Permission p on c.id = p.category.id" +
                " where p.role.id=:roleId" +
                " and c.categoryParentId=:parentId";
        Query query = entityManager.createQuery(sql);
        query.setParameter("roleId", roleId);
        query.setParameter("parentId", parentId);
        return query.getResultList();
    }
}
