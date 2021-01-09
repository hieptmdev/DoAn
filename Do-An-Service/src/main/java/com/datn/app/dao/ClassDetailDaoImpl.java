package com.datn.app.dao;

import com.datn.app.dao.crud.CrudClassDetail;
import com.datn.app.entity.ClassDetail;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ClassDetailDaoImpl extends BaseDao<ClassDetail> implements CrudClassDetail {
    public ClassDetailDaoImpl() {
        super(ClassDetail.class);
    }

    @Override
    public ClassDetail saveEntity(ClassDetail entity) {
        return save(entity);
    }

    @Override
    public List<ClassDetail> saveAllEntities(List<ClassDetail> entities) {
        return saveAll(entities);
    }
}
