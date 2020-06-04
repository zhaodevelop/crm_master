package com.ruanyuan.crm_master.service;

import java.util.List;

import com.ruanyuan.crm_master.pojo.Customer;

/**
 * 客户业务类
 *
 * @author zbp
 */
public interface CustomerService {
    /**
     * 添加客户
     *
     * @param customer
     * @return 影响的行数
     */
    public int addCustomer(Customer customer);

    /**
     * 删除客户
     *
     * @param id
     * @return 影响的行数
     */
    public int deleteCustomer(int id);

    /**
     * 修改客户
     *
     * @param customer
     * @return 影响的行数
     */
    public int updateCustomer(Customer customer);

    /**
     * 获取所有客户
     *
     * @return 客户信息集合
     */
    public List<Customer> getAllCustomer();

    /**
     * 多条件获取所有客户
     *
     * @return 分页后客户信息
     */
    public List<Customer> getAllCustomer(String custName);

    /**
     * 根据id查询客户信息
     *
     * @param id 客户id
     * @return 客户实体类对象
     */
    public Customer getCustomerById(int id);

    /**
     * 批量删除客户
     *
     * @param CustomerList 客户id集合
     */
    public int deleteMoreCustomer(Integer[] CustomerList);


}
