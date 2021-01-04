package com.datn.app.dao;

import com.datn.app.dao.crud.CrudSubjectDao;
import com.datn.app.entity.Subjects;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SubjectDaoImpl extends BaseDao<Subjects> implements CrudSubjectDao {
    public SubjectDaoImpl() {
        super(Subjects.class);
    }
}
