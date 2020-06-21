package com.ruanyuan.crm_master.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruanyuan.crm_master.annotation.ActorLog;
import com.ruanyuan.crm_master.pojo.LoginLog;
import com.ruanyuan.crm_master.service.LoginLogService;
import com.ruanyuan.crm_master.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;


@RestController
@RequestMapping("/LoginLog")
public class LoginLogController {
    //注入登录日志业务层
    @Autowired
    private LoginLogService loginLogService;

    //分页展示所有登录日志信息
    @GetMapping("/getAllLoginLog/{page}/{size}")
    public PageInfo<LoginLog> getAllLogingLogs(@PathVariable("page") int pageNo, @PathVariable("size") int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        //执行查询所有登录日志方法
        List<LoginLog> allLogingLogs = loginLogService.getAllLoginLog();
        //对登录日志列表进行分页
        PageInfo<LoginLog> logingLogPageInfo = new PageInfo<LoginLog>(allLogingLogs);
        return logingLogPageInfo;
    }


    //删除登录日志记录方法
    @ActorLog("删除日志记录")
    @RequestMapping("/deleteLogingLog/{id}")
    public int deleteLogingLog(@PathVariable("id") Integer id) {
        //执行删除登录日志方法
        int i = loginLogService.deleteLoginLog(id);
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //多条件查询登录日志信息
    @PostMapping("/getMoreAllLogingLogs/{page}/{size}")
    public PageInfo<LoginLog> getAlllogingLogs(@RequestBody @PathVariable("page") int pageNo, @PathVariable("size") int pageSize, String logTime, String endTime) {
        PageHelper.startPage(pageNo, pageSize);
        //执行查询所有登录日志方法
        List<LoginLog> alllogingLogs = loginLogService.getAllLoginLog(logTime, endTime);
        //对登录日志列表进行分页
        PageInfo<LoginLog> interPageInfo = new PageInfo<LoginLog>(alllogingLogs);
        return interPageInfo;
    }

    @GetMapping("/getAllLogingLogs")
    public List<LoginLog> getAlllogingLogs() {
        //执行查询所有登录日志方法
        List<LoginLog> alllogingLogs = loginLogService.getAllLoginLog();
        return alllogingLogs;
    }

    //批量删除登录日志信息`
    @ActorLog("批量删除日志")
    @DeleteMapping("/delLogingLogs")
    public int dellogingLogs(Integer[] ids) {
        //执行批量删除方法
        int i = loginLogService.deleteMoreLoginLog(ids);
        //判断执行情况
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //添加登录日志信息方法
    @PostMapping("/addLogingLog")
    public int addlogingLog(LoginLog logingLog) {
        //执行添加登录日志信息方法
        int sign = loginLogService.addLoginLog(logingLog);
        //判断执行情况
        if (sign > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //根据id修改登录日志信息
    @PutMapping("/updateLogingLog")
    public int updatelogingLog(@RequestBody LoginLog logingLog) {
        //执行修改方法
        int i = loginLogService.updateLoginLog(logingLog);
        //判断执行情况
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Excel下载
     *
     * @param response response作用域
     * @throws Exception
     */
    @CrossOrigin
    @GetMapping("/download")
    public void download(HttpServletResponse response) throws Exception {
        //查询全部登录日志信息
        List<LoginLog> loginLogs = loginLogService.getAllLoginLog();
        // 定义导出excel的名称
        String excelName = "员工信息表";
        // 获取需要转出的excle表头的map字段
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<String, String>();
        fieldMap.put("logId", "日志ID");
        fieldMap.put("logIp", "登录IP");
        fieldMap.put("logTime", "登录时间");
        fieldMap.put("logaddr", "登录地址");
        fieldMap.put("employee.empName", "用户");
        //导出所有员工信息
        ExcelUtil.export(excelName, loginLogs, fieldMap, response);
    }

}
