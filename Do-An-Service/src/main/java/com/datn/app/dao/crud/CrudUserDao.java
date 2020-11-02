package com.datn.app.dao.crud;

import com.datn.app.entity.User;
import org.springframework.data.domain.Page;

public interface CrudUserDao {
    User saveEntity(User user);
}
