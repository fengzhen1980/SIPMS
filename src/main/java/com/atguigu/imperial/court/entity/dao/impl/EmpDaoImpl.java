package com.atguigu.imperial.court.entity.dao.impl;

import com.atguigu.imperial.court.entity.Emp;
import com.atguigu.imperial.court.entity.dao.BaseDao;
import com.atguigu.imperial.court.entity.dao.api.EmpDao;

public class EmpDaoImpl extends BaseDao<Emp> implements EmpDao {
    @Override
    public Emp selectEmpByLoginAccount(String loginAccount, String encodedLoginPassword) {

        // 1. 编写 SQL 语句
        String sql = "select emp_id empId, " +
                "emp_name empName, " +
                "emp_position empPosition, " +
                "login_account loginAccount, " +
                "login_password loginPassword " +
                "from t_emp where login_account=? and login_password=?";

        // 2. 调用父类的方法查询单个对象
        return  super.getSingleBean(sql, Emp.class, loginAccount, encodedLoginPassword);

    }
}
