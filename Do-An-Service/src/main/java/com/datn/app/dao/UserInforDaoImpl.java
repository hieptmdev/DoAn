package com.datn.app.dao;

import com.datn.app.dao.crud.CrudUserInforDao;
import com.datn.app.entity.UserInfor;
import org.hibernate.mapping.PersistentClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class UserInforDaoImpl extends BaseDao<UserInfor> implements CrudUserInforDao {
    public UserInforDaoImpl() {
        super(UserInfor.class);
    }

    @Override
    public Page<UserInfor> search(Pageable pageable, String code, String name, String username, Long unitId) {
        Map<String, Object> params = new HashMap<>();
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ui FROM UserInfor ui WHERE 1=1");
        if (code != null && !code.equals("")){
            sql.append(" AND LOWER(ui.code) LIKE CONCAT('%',:code,'%')");
            params.put("code", code);
        }
        if (name != null && !name.equals("")) {
            sql.append(" AND (LOWER(ui.firstName) LIKE CONCAT('%',:firstName,'%') OR LOWER(ui.lastName) LIKE CONCAT('%',:lastName,'%'))");
            params.put("firstName", name);
            params.put("lastName", name);
        }
        if (username != null && !username.equals("")) {
            sql.append(" AND LOWER(ui.user.username) LIKE CONCAT('%',:username,'%')");
            params.put("username", username);
        }
        if (unitId != null && unitId != 0) {
            sql.append(" AND ui.unit.id=:unitId");
            params.put("unitId", unitId);
        }
        sql.append(" ORDER BY ui.firstName ASC , ui.lastName ASC");
        return paginator(pageable, sql.toString(), "ui", params);
    }

    @Override
    public UserInfor saveEntity(UserInfor userInfor) {
        return save(userInfor);
    }

    @Override
    public Page<UserInfor> searchTeacher(Pageable pageable, String code, String name, Long departmentId, Long unitId) {
        Map<String, Object> params = new HashMap<>();
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ui FROM UserInfor ui WHERE 1=1 AND ui.role.id=6");
        if (code != null && !code.equals("")){
            sql.append(" AND LOWER(ui.code) LIKE CONCAT('%',:code,'%')");
            params.put("code", code);
        }
        if (name != null && !name.equals("")) {
            sql.append(" AND (LOWER(ui.firstName) LIKE CONCAT('%',:firstName,'%') OR LOWER(ui.lastName) LIKE CONCAT('%',:lastName,'%'))");
            params.put("firstName", name);
            params.put("lastName", name);
        }
        if (departmentId != null && departmentId != 0L) {
            sql.append(" AND ui.department.id=:departmentId");
            params.put("departmentId", departmentId);
        }
        if (unitId != null && unitId != 0L) {
            sql.append(" AND ui.unit.id=:unitId");
            params.put("unitId", unitId);
        }
        sql.append(" ORDER BY ui.firstName ASC , ui.lastName ASC");
        return paginator(pageable, sql.toString(), "ui", params);
    }

    @Override
    public List<UserInfor> findAllTeacherByDepartment(Long departmentId) {
        String sql = "SELECT ui FROM UserInfor ui where ui.role.id IN (4, 5, 6) AND ui.department.id=:departmentId";
        Query query = entityManager.createQuery(sql);
        query.setParameter("departmentId", departmentId);
        return query.getResultList();
    }
}
