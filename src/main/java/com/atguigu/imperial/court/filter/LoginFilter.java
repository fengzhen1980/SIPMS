package com.atguigu.imperial.court.filter;

import com.atguigu.imperial.court.util.SipmsCourtConst;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // 1. 获取 HttpSession 对象
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        HttpSession session = httpServletRequest.getSession();

        // 2. 尝试从 session 域获取已登录的对象
        Object loginUser = session.getAttribute(SipmsCourtConst.LOGIN_USER_ATTR_NAME);

        // 3. 判断 loginEmp 是否为空
        if (loginUser != null) {
            // 4. 若不为空则说明当前请求已登录，直接放行
            chain.doFilter(httpServletRequest, response);

            return;
        }
        // 5. 若为空说明尚未登录，则回到登录页面
        httpServletRequest.setAttribute("systemMessage", SipmsCourtConst.ACCESS_DENIED_MESSAGE);
        httpServletRequest.getRequestDispatcher("/").forward(httpServletRequest, response);
    }

    @Override
    public void destroy() {

    }
}
