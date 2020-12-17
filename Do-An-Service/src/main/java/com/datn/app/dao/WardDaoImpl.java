package com.datn.app.dao;

import com.datn.app.dao.crud.CrudWardDao;
import com.datn.app.entity.Ward;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class WardDaoImpl extends BaseDao<Ward> implements CrudWardDao {
    public WardDaoImpl() {
        super(Ward.class);
    }
}
