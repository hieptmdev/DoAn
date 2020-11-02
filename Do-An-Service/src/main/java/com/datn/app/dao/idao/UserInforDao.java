package com.datn.app.dao.idao;

import com.datn.app.dao.crud.CrudUserInforDao;
import com.datn.app.entity.User;
import com.datn.app.entity.UserInfor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInforDao extends JpaRepository<UserInfor, Long>, CrudUserInforDao {
    UserInfor findByUser(User user);
}
