package com.datn.app.dao.idao;

import com.datn.app.dao.crud.CrudProvinceDao;
import com.datn.app.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProvinceDao extends JpaRepository<Province, Long>, CrudProvinceDao {
}
