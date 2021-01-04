package com.datn.app.dao.idao;

import com.datn.app.dao.crud.CrudClassDetail;
import com.datn.app.entity.Class;
import com.datn.app.entity.ClassDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassDetailDao extends JpaRepository<ClassDetail, Long>, CrudClassDetail {
    List<ClassDetail> findAllByClassSubject(Class classSubject);
}
