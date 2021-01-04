package com.datn.app.dao.idao;

import com.datn.app.dao.crud.CrudClassDao;
import com.datn.app.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassDao extends JpaRepository<Class, Long>, CrudClassDao {
}
