package com.atguigu.imperial.court.service.api;

import com.atguigu.imperial.court.entity.TUser;

public interface UserService {
    TUser getUserByLoginUserName(String loginUserName, String loginPassword);
}
