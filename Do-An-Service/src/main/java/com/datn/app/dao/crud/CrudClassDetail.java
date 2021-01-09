package com.datn.app.dao.crud;

import com.datn.app.entity.ClassDetail;

import java.util.List;

public interface CrudClassDetail {
    ClassDetail saveEntity(ClassDetail entity);

    List<ClassDetail> saveAllEntities(List<ClassDetail> entities);
}
