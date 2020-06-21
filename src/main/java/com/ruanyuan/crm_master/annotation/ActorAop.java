package com.ruanyuan.crm_master.annotation;

import com.ruanyuan.crm_master.pojo.ActionLog;
import com.ruanyuan.crm_master.pojo.Employee;
import com.ruanyuan.crm_master.service.ActionLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日志切面类
 */
@Aspect
@Component
public class ActorAop {
    //注入操作日志业务层
    @Autowired
    private ActionLogService actionLogService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ActorLog.class);

    /**
     * 使用后置通知，并配置切入点表达式，联合自定义控制层日志注解，记录日志
     *
     * @param joinPoint
     * @param actorLog
     */
    @After("execution(* com.ruanyuan.crm_master.controller.*.*(..)) && @annotation(actorLog)")
    public void afterControllerLog(JoinPoint joinPoint, ActorLog actorLog) {
        // 获取此次请求的request对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //获取session
        HttpSession session = request.getSession();
        //获取操作类型
        String logValue = actorLog.value();
        //获取操作内容
        String actContent = "用户执行了【" + logValue + "】操作";
        //获取当前登录人的信息
        Employee employee = (Employee) session.getAttribute("employee");
        //获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());
        //实例化操作日志实体类
        ActionLog actionLog = new ActionLog();
        actionLog.setActTime(date);
        actionLog.setEmployee(employee);
        actionLog.setOperateContent(actContent);
        actionLog.setActType(logValue);
        //执行添加方法
        actionLogService.addActionLog(actionLog);
    }
}
