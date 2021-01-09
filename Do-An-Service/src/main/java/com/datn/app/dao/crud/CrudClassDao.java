package com.datn.app.dao.crud;

import com.datn.app.entity.Class;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CrudClassDao {
    Class saveEntity(Class entity);

    Page<Class> search(Pageable pageable, String code, String name, Long courseId,
                       Long unitId, Long departmentId, Long subjectId);

    List<Class> findAllClassSameSubject(long parseLong, long parseLong1, long parseLong2);
}
