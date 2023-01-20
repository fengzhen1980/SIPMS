package com.atguigu.imperial.court.servlet.module;

import com.atguigu.imperial.court.entity.TUser;
import com.atguigu.imperial.court.exception.LoginFailedException;
import com.atguigu.imperial.court.service.api.UserService;
import com.atguigu.imperial.court.service.impl.UserServiceImpl;
import com.atguigu.imperial.court.servlet.base.ModelBaseServlet;
import com.atguigu.imperial.court.util.SipmsCourtConst;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthServlet extends ModelBaseServlet {

    private UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // 1. 获取请求参数
            String loginUserName = request.getParameter("loginUserName");
            String loginPassword = request.getParameter("loginPassword");

            // 2. 调用 EmpService.getEmpByLoginAccount() 方法执行登录逻辑
            TUser tUser = userService.getUserByLoginUserName(loginUserName, loginPassword);

            // 3. 通过 request 获取 HttpSession 对象
            HttpSession session = request.getSession();

            // 4. 将查询到的 Emp 对象存入 Session 域
            session.setAttribute(SipmsCourtConst.LOGIN_USER_ATTR_NAME, tUser);

            // 5.前往指定的页面视图
            // 前往临时页面
            // String templateName = "temp";
            //processTemplate(templateName, request, response);
            // 前往正式的目标地址
            response.sendRedirect(request.getContextPath() + "/work?method=showMemorialsDigestList");

        } catch (Exception e) {
            e.printStackTrace();

            // 6. 此处捕获到的异常是否是登录失败异常
            if (e instanceof LoginFailedException) {
                // 7. 如果是登录失败异常则跳转回登录页面
                // 将异常信息存入请求域
                request.setAttribute("message", e.getMessage());
                // 处理视图：index
                processTemplate("index", request, response);
            } else {
                // 8.如果不是登录异常则封装为运行时异常继续抛出
                throw new RuntimeException(e);
            }
        }

    }

    protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. 通过 request 对象获取 HttpSession 对象
        HttpSession session = request.getSession();

        // 2. 将 HttpSession 对象强制失效
        session.invalidate();

        // 3. 回到首页
        String templateName = "index";
        processTemplate(templateName, request, response);
    }
}
