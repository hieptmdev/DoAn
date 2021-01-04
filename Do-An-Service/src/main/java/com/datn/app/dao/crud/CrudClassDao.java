package com.datn.app.dao.crud;

import com.datn.app.entity.Class;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudClassDao {
    Class saveEntity(Class entity);

    Page<Class> search(Pageable pageable, String code, String name, Long courseId,
                       Long unitId, Long departmentId, Long subjectId);
}
