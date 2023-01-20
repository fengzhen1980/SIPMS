package com.atguigu.imperial.court.entity.dao.api;

import com.atguigu.imperial.court.entity.TUser;

public interface TUserDao {
    TUser selectUserByLoginUserName(String loginUserId, String loginPassword);

    TUser selectUserByUserId(String userId);

    void insertUser(TUser newUser);
}
