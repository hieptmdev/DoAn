package com.datn.app.dao.idao;

import com.datn.app.dao.crud.CrudRoleDao;
import com.datn.app.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long>, CrudRoleDao {
}
