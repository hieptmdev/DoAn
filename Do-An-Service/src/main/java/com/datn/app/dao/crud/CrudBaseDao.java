package com.datn.app.dao.crud;

import com.datn.app.entity.BaseEnt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Map;

@NoRepositoryBean
public interface CrudBaseDao<T> {
    <S extends T> S save(S entity);

    <S extends T> List<S> saveAll(List<S> entities);

    Page<T> paginator(Pageable pageable, String query, String alias, Map<String, Object> params);
}
