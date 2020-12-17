package com.datn.app.dao.idao;

import com.datn.app.dao.crud.CrudDistrictDao;
import com.datn.app.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictDao extends JpaRepository<District, Long>, CrudDistrictDao {
}
