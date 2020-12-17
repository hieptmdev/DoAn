package com.datn.app.dao;

import com.datn.app.dao.crud.CrudBaseDao;
import com.datn.app.entity.BaseEnt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class BaseDao<T extends BaseEnt> implements CrudBaseDao<T> {
    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> persistentClass;

    public BaseDao(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    @Override
    public <S extends T> S save(S entity) {
        if (entity.getId() == null || entity.getId() == 0){
            entity.setCreatedDate(new Date());
            entity.setUpdatedDate(new Date());
            entityManager.persist(entity);
        }else {
            entity.setUpdatedDate(new Date());
            entity = entityManager.merge(entity);
        }
        return entity;
    }

    @Override
    public Page<T> paginator(Pageable pageable, String query, String alias, Map<String, Object> params) {
        Query jpaQuery = entityManager.createQuery(query);
        jpaQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        jpaQuery.setMaxResults(pageable.getPageSize());
        if (params!=null && params.size()>0) {
            //params.forEach(jpaQuery::setParameter);
            for (Map.Entry<String, Object> entry : params.entrySet()){
                jpaQuery.setParameter(entry.getKey(), entry.getValue());
            }
        }
        List<T> resultList = jpaQuery.getResultList();
        //create query for count total result
        String jpaQueryTotalStr = query.replaceFirst("(?i)(select)(.+?)(from)", "select count("+alias+".id) from");
        Query jpaQueryTotal = entityManager.createQuery(jpaQueryTotalStr);
        if (params!=null && params.size()>0) {
            //params.forEach(jpaQueryTotal::setParameter);
            for (Map.Entry<String, Object> entry : params.entrySet()){
                jpaQueryTotal.setParameter(entry.getKey(), entry.getValue());
            }
        }
        long totalRecord = (long) jpaQueryTotal.getSingleResult();
        return new PageImpl<>(resultList, pageable, totalRecord);
    }
}
