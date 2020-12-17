package com.datn.app.dao;

import com.datn.app.dao.crud.CrudCourseDao;
import com.datn.app.entity.Course;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CourseDaoImpl extends BaseDao<Course> implements CrudCourseDao {
    public CourseDaoImpl() {
        super(Course.class);
    }

    @Override
    public Course saveEntity(Course entity) {
        return save(entity);
    }
}
