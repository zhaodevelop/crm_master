package com.ruanyuan.crm_master.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruanyuan.crm_master.pojo.Interview;
import com.ruanyuan.crm_master.service.EmployeeService;
import com.ruanyuan.crm_master.service.InterviewService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("Interview")
public class InterviewController {
    //注入访谈业务类
    @Autowired
    private InterviewService interviewService;
    //注入员工业务类
    @Autowired
    private EmployeeService employeeService;

    //分页展示所有访谈信息
    @GetMapping("/getAllInters/{page}/{size}")
    public PageInfo<Interview> getAllInters(@PathVariable("page") int pageNo, @PathVariable("size") int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        //执行查询所有部门方法
        List<Interview> allInters = interviewService.getAllInterview();
        PageInfo<Interview> interPageInfo = new PageInfo<Interview>(allInters);
        return interPageInfo;
    }

    //多条件查询访谈信息
    @PostMapping("/getMoreAllInters/{page}/{size}")
    public PageInfo<Interview> getAllInters(@PathVariable("page") int pageNo, @PathVariable("size") int pageSize, String custName, String empName, String interDatetime, String endTime) {
        PageHelper.startPage(pageNo, pageSize);
        //执行查询所有部门方法
        List<Interview> allInters = interviewService.getAllInterview(custName, empName, interDatetime, endTime);
        PageInfo<Interview> interPageInfo = new PageInfo<Interview>(allInters);
        return interPageInfo;
    }

    //删除访谈记录方法
    @RequestMapping("/deleteInterview/{id}")
    public int deleteInterview(@PathVariable("id") Integer id) {
        //执行删除客户方法
        int i = interviewService.deleteInterview(id);
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //添加访谈信息方法
    @PostMapping("/addInterview")
    public int addInterview(Interview interview) {
        //格式化时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());
        //添加访谈时间
        interview.setInterDatetime(date);
        //执行添加访谈信息方法
        int sign = interviewService.addInterview(interview);
        //判断执行情况
        if (sign > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //批量删除访谈信息
    @DeleteMapping("/delInters")
    public int delInters(Integer[] ids) {
        //执行批量删除方法
        int i = interviewService.deleteMoreInterview(ids);
        //判断执行情况
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //根据id修改客户信息
    @PutMapping("/updateInterview")
    public int updateInterview(@RequestBody Interview interview) {
        System.out.println(interview);
        //执行修改方法
        int i = interviewService.updateInterview(interview);
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
    @RequestMapping("/download")
    public void download(HttpServletResponse response) throws Exception {
        System.out.println("9999999999999999999999999999999");
        //查询全部访谈信息
        List<Interview> interviews = interviewService.getAllInterview();
        //创建一个工作簿
        @SuppressWarnings("resource")
        Workbook workbook = new XSSFWorkbook();
        //sheet1
        Sheet sheet = workbook.createSheet("访谈信息");
        //定义sheet1标题
        String[] titles = {"客户名称", "负责人", "访谈内容", "创建时间"};
        //行
        Row row = sheet.createRow(0);
        //写sheet1入标题行
        for (int i = 0; i < titles.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(titles[i]);
        }
        /**
         * sheet1插入数据
         */
        for (int i = 0; i < interviews.size(); i++) {
            //第一行开始
            row = sheet.createRow(i + 1);
            Interview inter = interviews.get(i);
            //分别向表格中赋值
            row.createCell(0).setCellValue(inter.getCustomer().getCustName());
            row.createCell(1).setCellValue(inter.getEmployee().getEmpName());
            row.createCell(2).setCellValue(inter.getInterInfo());
            row.createCell(3).setCellValue(inter.getInterDatetime().substring(0, 16));
        }
        //创建文件名称
        String fileName = URLEncoder.encode("访谈信息.xlsx", "UTF-8");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.setHeader("filename", fileName);
        //写入文件
        workbook.write(response.getOutputStream());
    }
}
