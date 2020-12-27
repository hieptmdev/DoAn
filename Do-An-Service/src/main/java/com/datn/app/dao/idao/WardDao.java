package com.datn.app.dao.idao;

import com.datn.app.dao.crud.CrudWardDao;
import com.datn.app.entity.Ward;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WardDao extends JpaRepository<Ward, Long>, CrudWardDao {
    List<Ward> findAllByProvinceIdAndAndDistrictId(Long provinceId, Long districtId, Sort sort);
}
