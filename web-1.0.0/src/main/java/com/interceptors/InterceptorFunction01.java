package com.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/12/30 0030.
 */
public class InterceptorFunction01 implements HandlerInterceptor {
    /**
     * 返回值
     * true:不拦截
     * false：拦截
     * Object o:表示拦截的目标对象
     */
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHandle1");
        /**
         * 拦截器设置过滤的请求编码格式为utf-8,跟在web.xml里设置的过滤器作用相同;
         */
        httpServletRequest.setCharacterEncoding("utf-8");

        return true;
    }

    /**
     * ModuleAndView:可以改变显示的视图，或发往视图的方法;
     */
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle1");
    }

    /*
     *响应结束之后的方法
     */
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion1");
    }


}
