package com.atguigu.imperial.court.entity.dao.api;

import com.atguigu.imperial.court.entity.Emp;

public interface EmpDao {
    Emp selectEmpByLoginAccount(String loginAccount, String encodedLoginPassword);
}
