package com.datn.app.dao.idao;

import com.datn.app.dao.crud.CrudDistrictDao;
import com.datn.app.entity.District;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictDao extends JpaRepository<District, Long>, CrudDistrictDao {
    List<District> findAllByProvinceId(Long providerId, Sort sort);
}
