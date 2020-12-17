package com.datn.app.dao.idao;

import com.datn.app.dao.crud.CrudCourseDao;
import com.datn.app.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long>, CrudCourseDao {
}
