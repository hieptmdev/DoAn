package com.datn.app.dao;

import com.datn.app.dao.crud.CrudDepartmentDao;
import com.datn.app.entity.Department;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DepartmentDaoImpl extends BaseDao<Department> implements CrudDepartmentDao {
    public DepartmentDaoImpl() {
        super(Department.class);
    }
}
