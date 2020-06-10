//package com.ruanyuan.crm_master.Intercepter;
//
//import org.springframework.lang.Nullable;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@Component
//@CrossOrigin
//public class LoginIntercepter implements HandlerInterceptor {
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpSession session = request.getSession();
//        //获取session对象
//        Object employee1 = session.getAttribute("employee");
//        if (employee1 == null) {
//            return false;
//        }
//        return true;
//    }
//
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
//    }
//
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//    }
//
//
//}
