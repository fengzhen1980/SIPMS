package com.atguigu.imperial.court.service.impl;

import com.atguigu.imperial.court.entity.TUser;
import com.atguigu.imperial.court.entity.dao.api.TUserDao;
import com.atguigu.imperial.court.entity.dao.impl.TUserDaoImpl;
import com.atguigu.imperial.court.service.api.RegisterService;

public class RegisterServiceImpl implements RegisterService {

    private TUserDao tUserDao = new TUserDaoImpl();

    @Override
    public TUser getUserByUserId(String userId) {
        return tUserDao.selectUserByUserId(userId);
    }

    @Override
    public void registerUser(TUser newUser) {
        tUserDao.insertUser(newUser);
    }
}
