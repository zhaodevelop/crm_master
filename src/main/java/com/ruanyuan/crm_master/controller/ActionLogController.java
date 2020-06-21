package com.ruanyuan.crm_master.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruanyuan.crm_master.annotation.ActorLog;
import com.ruanyuan.crm_master.pojo.ActionLog;
import com.ruanyuan.crm_master.service.ActionLogService;
import com.ruanyuan.crm_master.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/ActionLog")
public class ActionLogController {
    //注入操作日志业务层
    @Autowired
    private ActionLogService actionLogService;

    //分页展示所有操作日志信息
    @GetMapping("/getAllActionLog/{page}/{size}")
    public PageInfo<ActionLog> getAllActionLog(@PathVariable("page") int pageNo, @PathVariable("size") int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        //执行查询所有操作日志方法
        List<ActionLog> allActionLogs = actionLogService.getAllActionLog();
        //对操作日志列表进行分页
        PageInfo<ActionLog> ActionLogPageInfo = new PageInfo<ActionLog>(allActionLogs);
        return ActionLogPageInfo;
    }

    //多条件查询操作日志信息
    @PostMapping("/getMoreActionLogs/{page}/{size}")
    public PageInfo<ActionLog> getMoreAllActionLogs(@RequestBody @PathVariable("page") int pageNo, @PathVariable("size") int pageSize, String empName, String actTime, String endTime) {
        PageHelper.startPage(pageNo, pageSize);
        //执行查询所有操作日志方法
        List<ActionLog> allActionLogs = actionLogService.getActionLog(empName, actTime, endTime);
        //对操作日志列表进行分页
        PageInfo<ActionLog> ActionPageInfo = new PageInfo<ActionLog>(allActionLogs);
        return ActionPageInfo;
    }

    //删除操作日志记录方法
    @ActorLog("删除操作日志信息")
    @RequestMapping("/deleteActionLog/{id}")
    public int deleteActionLog(@PathVariable("id") Integer id) {
        //执行删除操作日志方法
        int i = actionLogService.deleteActionLog(id);
        //判断执行情况
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //批量删除操作日志信息`
    @ActorLog("批量删除操作日志信息")
    @DeleteMapping("/delActionLogs")
    public int delActionLogs(Integer[] ids) {
        //执行批量删除方法
        int i = actionLogService.deleteMoreActionLog(ids);
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
        //查询全部操作日志信息
        List<ActionLog> loginLogs = actionLogService.getAllActionLog();
        // 定义导出excel的名称
        String excelName = "操作日志信息表";
        // 获取需要转出的excle表头的map字段
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<String, String>();
        fieldMap.put("actLogId", "操作日志ID");
        fieldMap.put("actTime", "操作时间");
        fieldMap.put("actType", "操作类型");
        fieldMap.put("operateContent", "操作内容");
        fieldMap.put("employee.empName", "用户");
        //导出所有员工信息
        ExcelUtil.export(excelName, loginLogs, fieldMap, response);
    }
}
