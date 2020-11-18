package com.datn.app.dao;

import com.datn.app.dao.crud.CrudCodeResetPasswordDao;
import com.datn.app.entity.CodeResetPassword;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CodeResetPasswordDaoImpl extends BaseDao<CodeResetPassword> implements CrudCodeResetPasswordDao {
    public CodeResetPasswordDaoImpl() {
        super(CodeResetPassword.class);
    }

    @Override
    public CodeResetPassword saveEntity(CodeResetPassword codeResetPassword) {
        return save(codeResetPassword);
    }
}
