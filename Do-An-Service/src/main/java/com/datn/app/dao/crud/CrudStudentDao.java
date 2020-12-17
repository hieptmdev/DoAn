package com.datn.app.dao.crud;

import com.datn.app.entity.Students;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudStudentDao {
    Students saveEntity(Students ent);

    Page<Students> search(Pageable pageable, String code, String name, Long courseId, Long unitId);
}
