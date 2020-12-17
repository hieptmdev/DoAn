package com.datn.app.dao.crud;

import com.datn.app.entity.Unit;

import java.util.List;

public interface CrudUnitDao {
    Unit saveEntity(Unit entity);

    List<Unit> findAllForStudent(Long unitId);
}
