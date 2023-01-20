package com.atguigu.imperial.court.entity.dao.impl;

import com.atguigu.imperial.court.entity.Memorials;
import com.atguigu.imperial.court.entity.dao.BaseDao;
import com.atguigu.imperial.court.entity.dao.api.MemorialsDao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MemorialsDaoImpl extends BaseDao<Memorials> implements MemorialsDao {
    @Override
    public List<Memorials> selectAllMemorialsDigest() {
         String sql = "select\n" +
                 "    m.memorials_id memorialsId,\n" +
                 "    m.memorials_title memorialsTitle,\n" +
                 "    concat(left(m.memorials_content, 10), \"...\") memorialsContentDigest,\n" +
                 "    e.emp_name memorialsEmpName,\n" +
                 "    m.memorials_create_time memorialsCreateTime,\n" +
                 "    m.memorials_status memorialsStatus\n" +
                 "from t_memorials m left join t_emp e on m.memorials_emp = emp_id;";

         return getBeanList(sql, Memorials.class);
    }

    @Override
    public Memorials selectMemorialsById(String memorialsId) {
        String sql = "select\n" +
                "    m.memorials_id memorialsId,\n" +
                "    m.memorials_title memorialsTitle,\n" +
                "    m.memorials_content memorialsContent,\n" +
                "    e.emp_name memorialsEmpName,\n" +
                "    m.memorials_create_time memorialsCreateTime,\n" +
                "    m.memorials_status memorialsStatus,\n" +
                "    m.feedback_time feedbackTime,\n" +
                "    m.feedback_content feedbackContent\n" +
                "from t_memorials m left join t_emp e on m.memorials_emp = emp_id " +
                "where m.memorials_id=?;";

        return getSingleBean(sql, Memorials.class, memorialsId);
    }

    @Override
    public void updateMemorialsToRead(String memorialsId) {
        String sql = "update t_memorials set memorials_status = 1 where memorials_id=?";
        update(sql, memorialsId);
    }

    @Override
    public void updateMemorialsFeedback(String memorialsId, String feedbackContent) {

        String feedbackTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        String sql = "update t_memorials set memorials_status=2, feedback_content=?, feedback_time=? where memorials_id=? ";

        System.out.println("******************************");
        System.out.println(sql);
        System.out.println(feedbackContent);
        System.out.println(feedbackTime);
        System.out.println(memorialsId);
        System.out.println("******************************");
        update(sql, feedbackContent, feedbackTime, memorialsId);
    }
}
