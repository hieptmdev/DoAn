package com.datn.app.dao.idao;

import com.datn.app.dao.crud.CrudSubjectDao;
import com.datn.app.entity.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectDao extends JpaRepository<Subjects, Long>, CrudSubjectDao {
    List<Subjects> findAllByDepartment_Id(Long departmentId);
}
