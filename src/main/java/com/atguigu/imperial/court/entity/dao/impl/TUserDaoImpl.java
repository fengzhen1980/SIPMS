package com.atguigu.imperial.court.entity.dao.impl;

import com.atguigu.imperial.court.entity.TUser;
import com.atguigu.imperial.court.entity.dao.BaseDao;
import com.atguigu.imperial.court.entity.dao.api.TUserDao;

public class TUserDaoImpl extends BaseDao<TUser> implements TUserDao {
    @Override
    public TUser selectUserByLoginUserName(String loginUserId, String loginPassword) {

        // 1. 编写 SQL 语句
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
                "from t_user where USER_Id=? and USER_PASSWORD=?";

        // 2. 调用父类的方法查询单个对象
        return super.getSingleBean(sql, TUser.class, loginUserId, loginPassword);
    }

    @Override
    public TUser selectUserByUserId(String userId) {
        // 1. 编写 SQL 语句
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
                "from t_user where USER_Id=?";

        // 2. 调用父类的方法查询单个对象
        return super.getSingleBean(sql, TUser.class, userId);
    }

    @Override
    public void insertUser(TUser user) {
        String sql = "insert into t_user " +
                "(USER_ID, " +
                "USER_PASSWORD, " +
                "USER_CATEGORY, " +
                "USER_FIRST_NAME, " +
                "USER_LAST_NAME, " +
                "USER_AGE, " +
                "USER_GENDER, " +
                "USER_EMAIL, " +
                "USER_ADDRESS) " +
                "values (?,?,?,?,?,?,?,?,?)";
        update(sql, user.getUserId(), user.getUserPassword(), user.getUserCategory(), user.getUserFirstName(),
                user.getUserLastName(), user.getUserAge(), user.getUserGender(), user.getUserEmail(),
                user.getUserAddress());
        
    }
}
