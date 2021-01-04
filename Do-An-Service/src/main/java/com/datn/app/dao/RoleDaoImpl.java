package com.datn.app.dao;

import com.datn.app.dao.crud.CrudRoleDao;
import com.datn.app.entity.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RoleDaoImpl extends BaseDao<Role> implements CrudRoleDao {
    public RoleDaoImpl() {
        super(Role.class);
    }
}
