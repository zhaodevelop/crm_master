package com.ruanyuan.crm_master.service.impl;

import java.util.List;

import com.ruanyuan.crm_master.dao.CustomerDao;
import com.ruanyuan.crm_master.pojo.Customer;
import com.ruanyuan.crm_master.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 客户业务接口实现类
 *
 * @author zbp
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    // 注入客户方法接口
    @Autowired
    private CustomerDao customerDao;

    /**
     * 添加客户
     */
    @Override
    public int addCustomer(Customer customer) {
        // TODO Auto-generated method stub
        return customerDao.addCustomer(customer);
    }

    /**
     * 删除客户
     */
    @Override
    public int deleteCustomer(int id) {
        // TODO Auto-generated method stub
        return customerDao.deleteCustomer(id);
    }

    /**
     * 修改客户
     */
    @Override
    public int updateCustomer(Customer customer) {
        // TODO Auto-generated method stub
        return customerDao.updateCustomer(customer);
    }

    /**
     * 获取所有客户
     */
    @Override
    public List<Customer> getAllCustomer() {
        // TODO Auto-generated method stub
        return customerDao.getAllCustomer();
    }

    /**
     * 根据用户姓名模糊查询
     *
     * @param custName 用户姓名
     * @return 用户信息集合
     */
    @Override
    public List<Customer> getAllCustomer(String custName) {
        return customerDao.getAllCustomer(custName);
    }

    /**
     * 根据客户id查询用户信息
     *
     * @param id 客户id
     * @return 客户信息
     */
    @Override
    public Customer getCustomerById(int id) {
        return customerDao.getCustomerById(id);
    }

    /**
     * 批量删除客户信息
     *
     * @param CustomerList 客户id集合
     * @return 影响的行数
     */
    @Override
    public int deleteMoreCustomer(Integer[] CustomerList) {
        return customerDao.deleteMoreCustomer(CustomerList);
    }


}
