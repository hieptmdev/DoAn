package com.datn.app.dao;

import com.datn.app.dao.crud.CrudStudentDao;
import com.datn.app.entity.Students;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Repository
@Transactional
public class StudentDaoImpl extends BaseDao<Students> implements CrudStudentDao {
    public StudentDaoImpl() {
        super(Students.class);
    }

    @Override
    public Students saveEntity(Students ent) {
        return save(ent);
    }

    @Override
    public Page<Students> search(Pageable pageable, String code, String name, Long courseId, Long unitId) {
        Map<String, Object> params = new HashMap<>();
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT st FROM Students st WHERE 1=1");
        if (code != null && !code.equals("")){
            sql.append(" AND LOWER(st.code) LIKE CONCAT('%',:code,'%')");
            params.put("code", code);
        }
        if (name != null && !name.equals("")) {
            sql.append(" AND LOWER(st.fullName) LIKE CONCAT('%',:name,'%')");
            params.put("name", name);
        }
        if (courseId != null && courseId != 0) {
            sql.append(" AND st.course.id=:courseId");
            params.put("courseId", courseId);
        }
        if (unitId != null && unitId != 0) {
            sql.append(" AND st.unit.id=:unitId");
            params.put("unitId", unitId);
        }
        sql.append(" ORDER BY st.fullName ASC , st.course.number DESC");
        return paginator(pageable, sql.toString(), "st", params);
    }
}
