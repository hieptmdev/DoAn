package com.datn.app.dao;

import com.datn.app.dao.crud.CrudNationDao;
import com.datn.app.entity.Nation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class NationDaoImpl extends BaseDao<Nation> implements CrudNationDao {
    public NationDaoImpl() {
        super(Nation.class);
    }
}
