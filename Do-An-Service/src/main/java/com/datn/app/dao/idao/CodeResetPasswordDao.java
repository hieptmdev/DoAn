package com.datn.app.dao.idao;

import com.datn.app.dao.crud.CrudCodeResetPasswordDao;
import com.datn.app.entity.CodeResetPassword;
import com.datn.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeResetPasswordDao extends JpaRepository<CodeResetPassword, Long>, CrudCodeResetPasswordDao {
    CodeResetPassword findByCode(String code);

    CodeResetPassword findByUser(User user);
}
