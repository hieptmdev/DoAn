package com.datn.app.dao;

import com.datn.app.dao.crud.CrudClassDao;
import com.datn.app.entity.Class;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Repository
@Transactional
public class ClassDaoImpl extends BaseDao<Class> implements CrudClassDao {
    public ClassDaoImpl() {
        super(Class.class);
    }

    @Override
    public Class saveEntity(Class entity) {
        return null;
    }

    @Override
    public Page<Class> search(Pageable pageable, String code, String name, Long courseId,
                              Long unitId, Long departmentId, Long subjectId) {
        Map<String, Object> params = new HashMap<>();
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT c FROM Class c WHERE 1=1");
        if (code != null && !code.equals("")){
            sql.append(" AND LOWER(c.code) LIKE CONCAT('%',:code,'%')");
            params.put("code", code);
        }
        if (name != null && !name.equals("")) {
            sql.append(" AND LOWER(c.name) LIKE CONCAT('%',:name,'%')");
            params.put("name", name);
        }
        if (courseId != null && courseId != 0) {
            sql.append(" AND c.course.id=:courseId");
            params.put("courseId", courseId);
        }
        if (unitId != null && unitId != 0) {
            sql.append(" AND c.unit.id=:unitId");
            params.put("unitId", unitId);
        }
        if (courseId != null && courseId != 0) {
            sql.append(" AND c.subjects.department.id=:departmentId");
            params.put("departmentId", departmentId);
        }
        if (unitId != null && unitId != 0) {
            sql.append(" AND c.subjects.id=:subjectId");
            params.put("subjectId", subjectId);
        }
        sql.append(" ORDER BY c.name ASC , c.course.number DESC");
        return paginator(pageable, sql.toString(), "c", params);
    }
}
