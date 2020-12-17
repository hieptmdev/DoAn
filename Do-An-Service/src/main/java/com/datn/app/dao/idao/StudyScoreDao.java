package com.datn.app.dao.idao;

import com.datn.app.dao.crud.CrudStudyScoreDao;
import com.datn.app.entity.StudyScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyScoreDao extends JpaRepository<StudyScore, Long>, CrudStudyScoreDao {
}
