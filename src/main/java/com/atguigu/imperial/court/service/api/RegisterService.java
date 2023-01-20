package com.atguigu.imperial.court.service.api;

import com.atguigu.imperial.court.entity.TUser;

public interface RegisterService {

    TUser getUserByUserId(String userId);

    void registerUser(TUser newUser);
}
