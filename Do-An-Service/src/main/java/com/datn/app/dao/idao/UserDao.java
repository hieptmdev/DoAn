package com.datn.app.dao.idao;

import com.datn.app.dao.crud.CrudUserDao;
import com.datn.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long>, CrudUserDao {
    User findByUsername(String username);
}
