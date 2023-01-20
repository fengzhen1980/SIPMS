package com.atguigu.maven;

import com.atguigu.imperial.court.entity.TUser;
import com.atguigu.imperial.court.entity.dao.BaseDao;
import com.atguigu.imperial.court.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

public class SipmsTest {

    private BaseDao<TUser> baseDao = new BaseDao<>();

    @Test
    public void testGetSingleBean() {

        String sql = "select " +
                "USER_ID userId, " +
                "USER_PASSWORD userPassword, " +
                "USER_CATEGORY userCategory, " +
                "USER_FIRST_NAME userFirstName, " +
                "USER_LAST_NAME userLastName, " +
                "USER_AGE userAge, " +
                "USER_GENDER userGender, " +
                "USER_EMAIL userEmail, " +
                "USER_ADDRESS userAddress " +
                "from t_user where USER_ID=?";

        TUser tUser = baseDao.getSingleBean(sql, TUser.class, "STUDENT001");

        System.out.println("tUser = " + tUser);
    }

    @Test
    public void testGetBeanList() {

        String sql = "select " +
                "USER_ID userId, " +
                "USER_PASSWORD userPassword, " +
                "USER_CATEGORY userCategory, " +
                "USER_FIRST_NAME userFirstName, " +
                "USER_LAST_NAME userLastName, " +
                "USER_AGE userAge, " +
                "USER_GENDER userGender, " +
                "USER_EMAIL userEmail, " +
                "USER_ADDRESS userAddress " +
                "from t_user ";

        List<TUser> tUserList = baseDao.getBeanList(sql, TUser.class);
        for (TUser tUser : tUserList) {
            System.out.println("tUser = " + tUser);
        }
    }

    @Test
    public void testUpdate() {
        String sql = "update t_emp set emp_position=? where emp_id=?";
        String empPosition = "minister";
        String empId = "3";

        int affectedRowNumber = baseDao.update(sql, empPosition, empId);

        System.out.println("affectedRowNumber = " + affectedRowNumber);
    }

    @Test
    public void testGetConnection() {
        Connection connection = JDBCUtils.getConnection();
        System.out.println("connection = " + connection);

        JDBCUtils.releaseConnection(connection);
    }
}
