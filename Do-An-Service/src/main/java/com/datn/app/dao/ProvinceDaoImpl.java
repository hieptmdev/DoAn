package com.datn.app.dao;

import com.datn.app.dao.crud.CrudProvinceDao;
import com.datn.app.entity.Province;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ProvinceDaoImpl extends BaseDao<Province> implements CrudProvinceDao {
    public ProvinceDaoImpl() {
        super(Province.class);
    }
}
