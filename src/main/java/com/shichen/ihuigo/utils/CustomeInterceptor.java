package com.shichen.ihuigo.utils;

import com.shichen.ihuigo.entity.Customer;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomeInterceptor implements HandlerInterceptor /*拦截器*/{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        Customer user = (Customer) request.getSession().getAttribute("user");
        if(user == null||"".equals(user.toString())){//说明用户当前没有登录，所以需要记录用户在未登录前访问的页面地址，然后等用户登录以后再跳回之前的页面
            response.sendRedirect("/WEB-INF/pages/login.jsp");

//            HttpSession session = request.getSession(true);
//            String uri = request.getRequestURI();//拿到上一个页面地址
//            String path = uri.substring(request.getContextPath().length());//去掉项目地址长度的字符（因为我的默认项目地址是给出的）
//            String query = request.getQueryString();//得到参数
//            if(query == null) {
//                query="";
//            }
//            else {
//                query="?"+query;
//            }
//            String beforePath = path+query;
//            session.setAttribute("beforePath", beforePath);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
