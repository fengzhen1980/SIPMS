package com.atguigu.imperial.court.service.impl;

import com.atguigu.imperial.court.entity.Memorials;
import com.atguigu.imperial.court.entity.dao.api.MemorialsDao;
import com.atguigu.imperial.court.entity.dao.impl.MemorialsDaoImpl;
import com.atguigu.imperial.court.service.api.MemorialsService;

import java.util.List;

public class MemorialsServiceImpl implements MemorialsService {

    private MemorialsDao memorialsDao = new MemorialsDaoImpl();

    @Override
    public List<Memorials> getAllMemorialsDigest() {
        return memorialsDao.selectAllMemorialsDigest();
    }

    @Override
    public Memorials getMemorialsDetailById(String memorialsId) {

        return memorialsDao.selectMemorialsById(memorialsId);
    }

    @Override
    public void updateMemorialsToRead(String memorialsId) {
        memorialsDao.updateMemorialsToRead(memorialsId);
    }

    @Override
    public void updateMemorialsFeedback(String memorialsId, String feedbackContent) {
        memorialsDao.updateMemorialsFeedback(memorialsId, feedbackContent);
    }
}
