package com.datn.app.dao;

import com.datn.app.dao.crud.CrudUserDao;
import com.datn.app.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDaoImpl extends BaseDao<User> implements CrudUserDao {
    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User saveEntity(User user) {
        return save(user);
    }
}
