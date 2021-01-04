package com.datn.app.dao.idao;

import com.datn.app.dao.crud.CrudDepartmentDao;
import com.datn.app.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentDao extends JpaRepository<Department, Long>, CrudDepartmentDao {
    List<Department> findAllByUnit_Id(Long unitId);
}
