package com.datn.app.dao;

import com.datn.app.dao.crud.CrudDistrictDao;
import com.datn.app.entity.District;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DistrictDaoImpl extends BaseDao<District> implements CrudDistrictDao {
    public DistrictDaoImpl() {
        super(District.class);
    }
}
