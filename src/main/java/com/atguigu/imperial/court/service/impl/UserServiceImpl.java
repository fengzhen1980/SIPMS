package com.atguigu.imperial.court.service.impl;

import com.atguigu.imperial.court.entity.TUser;
import com.atguigu.imperial.court.entity.dao.api.TUserDao;
import com.atguigu.imperial.court.entity.dao.impl.TUserDaoImpl;
import com.atguigu.imperial.court.exception.LoginFailedException;
import com.atguigu.imperial.court.service.api.UserService;
import com.atguigu.imperial.court.util.SipmsCourtConst;

public class UserServiceImpl implements UserService {

    private TUserDao tUserDao = new TUserDaoImpl();

    @Override
    public TUser getUserByLoginUserName(String loginUserName, String loginPassword) {
        // 根据用户名和加密密码查询数据库
        TUser tUser = tUserDao.selectUserByLoginUserName(loginUserName, loginPassword);

        // 检查 EMP 对象是否为null
        if (tUser != null) {
            // 不为null：返回 Emp
            return tUser;
        } else {
            // 为null：抛登录失败异常
            throw new LoginFailedException(SipmsCourtConst.LOGIN_FAILED_MESSAGE);
        }
    }
}
