package com.datn.app.dao;

import com.datn.app.dao.crud.CrudClassDetail;
import com.datn.app.entity.ClassDetail;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ClassDetailDaoImpl extends BaseDao<ClassDetail> implements CrudClassDetail {
    public ClassDetailDaoImpl() {
        super(ClassDetail.class);
    }
}
