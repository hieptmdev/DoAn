package com.datn.app.dao;

import com.datn.app.dao.crud.CrudStudyScoreDao;
import com.datn.app.entity.StudyScore;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudyScoreDaoImpl extends BaseDao<StudyScore> implements CrudStudyScoreDao {
    public StudyScoreDaoImpl() {
        super(StudyScore.class);
    }

    @Override
    public StudyScore saveEntity(StudyScore entity) {
        return save(entity);
    }
}
