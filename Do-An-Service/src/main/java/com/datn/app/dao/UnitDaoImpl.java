package com.datn.app.dao;

import com.datn.app.dao.crud.CrudUnitDao;
import com.datn.app.entity.Unit;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class UnitDaoImpl extends BaseDao<Unit> implements CrudUnitDao {
    public UnitDaoImpl() {
        super(Unit.class);
    }

    @Override
    public Unit saveEntity(Unit entity) {
        return save(entity);
    }

    @Override
    public List<Unit> findAllForStudent(Long unitId) {
        Query query;
        StringBuilder sql = new StringBuilder();
        sql.append("select u from Unit u where 1=1 and u.id not in (1, 2, 8) ");
        if (unitId != 1 && unitId != 2 && unitId != 3 && unitId != 8){
            sql.append("and u.id=:unitId ");
            sql.append("order by u.name");
            query = entityManager.createQuery(sql.toString());
            query.setParameter("unitId", unitId);
        }else {
            sql.append("order by u.name");
            query = entityManager.createQuery(sql.toString());
        }
        return query.getResultList();
    }
}
