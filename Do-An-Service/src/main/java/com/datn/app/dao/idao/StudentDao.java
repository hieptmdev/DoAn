package com.datn.app.dao.idao;

import com.datn.app.dao.crud.CrudStudentDao;
import com.datn.app.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Students, Long>, CrudStudentDao {
    Students findByCode(String code);
}
