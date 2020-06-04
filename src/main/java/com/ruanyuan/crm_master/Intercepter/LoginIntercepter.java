//package com.ruanyuan.crm_master.Intercepter;
//
//import com.ruanyuan.crm_master.pojo.Employee;
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
////        HttpSession session = request.getSession();
////        Employee employee = (Employee) session.getAttribute("employee");
////        if (employee == null) {
////            response.setContentType("application/json;charset=UTF-8");
////
////            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
////            response.setHeader("Access-Control-Max-Age", "3600");
////            response.setHeader("Access-Control-Allow-Credentials", "true");
////            response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
////            response.setHeader("Access-Control-Allow-Origin", "*");
////            response.sendRedirect("http://localhost:8080/Login");
////            return false;
////        } else {
////            System.out.println("2222222222222222222222");
////            return true;
////        }
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
