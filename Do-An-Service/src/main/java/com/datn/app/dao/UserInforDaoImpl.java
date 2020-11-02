package com.datn.app.dao;

import com.datn.app.dao.crud.CrudUserInforDao;
import com.datn.app.entity.UserInfor;
import org.hibernate.mapping.PersistentClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Repository
@Transactional
public class UserInforDaoImpl extends BaseDao<UserInfor> implements CrudUserInforDao {
    public UserInforDaoImpl() {
        super(UserInfor.class);
    }

    @Override
    public Page<UserInfor> search(Pageable pageable) {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ui FROM UserInfor ui");
        Map<String, Object> params = new HashMap<>();
        return paginator(pageable, sql.toString(), "ui", params);
    }

    @Override
    public UserInfor saveEntity(UserInfor userInfor) {
        return save(userInfor);
    }
}
