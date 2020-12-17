package com.datn.app.dao.idao;

import com.datn.app.dao.crud.CrudNationDao;
import com.datn.app.entity.Nation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NationDao extends JpaRepository<Nation, Long>, CrudNationDao {
}
