package com.datn.app.dao.idao;

import com.datn.app.dao.crud.CrudWardDao;
import com.datn.app.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WardDao extends JpaRepository<Ward, Long>, CrudWardDao {
}
