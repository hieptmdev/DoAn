package com.datn.app.dao.crud;

import com.datn.app.entity.UserInfor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudUserInforDao {
    Page<UserInfor> search(Pageable pageable);

    UserInfor saveEntity(UserInfor userInfor);
}
