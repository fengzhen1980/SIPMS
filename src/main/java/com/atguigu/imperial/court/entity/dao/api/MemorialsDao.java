package com.atguigu.imperial.court.entity.dao.api;

import com.atguigu.imperial.court.entity.Memorials;

import java.util.List;

public interface MemorialsDao {
    List<Memorials> selectAllMemorialsDigest();

    Memorials selectMemorialsById(String memorialsId);

    void updateMemorialsToRead(String memorialsId);

    void updateMemorialsFeedback(String memorialsId, String feedbackContent);
}
