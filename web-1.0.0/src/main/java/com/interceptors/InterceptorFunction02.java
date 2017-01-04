package com.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/12/30 0030.
 */
public class InterceptorFunction02 implements HandlerInterceptor {
    /**
     * 返回值
     * true:不拦截
     * false：拦截
     * Object o:表示拦截的目标对象
     */
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object o) throws Exception {
        System.out.println("preHandle2");
        /**
         * 判断用户是否登入，如果没有登入则踢到登入失败页面
         */
        System.out.println(req.getServletPath());
        System.out.println(req.getContextPath() + "11111");
        if (req.getSession().getAttribute("username") == null) {
//            req.getRequestDispatcher("/WEB-INF/views/loginfail.jsp").forward(req, res);
            res.sendRedirect(req.getContextPath() + "/WEB-INF/views/loginfail.jsp");
            return false;
        }
        return true;
    }

    /**
     * ModuleAndView:可以改变显示的视图，或发往视图的方法;
     */
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle2");
    }

    /*
     *响应结束之后的方法
     */
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion2");
    }


}
