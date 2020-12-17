package com.datn.app.dao.idao;

import com.datn.app.dao.crud.CrudUnitDao;
import com.datn.app.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitDao extends JpaRepository<Unit, Long>, CrudUnitDao {
}
