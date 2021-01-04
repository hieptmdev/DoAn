package com.datn.app.dao.crud;

import com.datn.app.entity.UserInfor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CrudUserInforDao {
    Page<UserInfor> search(Pageable pageable, String code, String name, String username, Long unitId);

    UserInfor saveEntity(UserInfor userInfor);

    Page<UserInfor> searchTeacher(Pageable pageable, String code, String name, Long departmentId, Long unitId);

    List<UserInfor> findAllTeacherByDepartment(Long departmentId);
}
