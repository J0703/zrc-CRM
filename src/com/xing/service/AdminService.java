package com.xing.service;

import com.xing.domain.Admin;
import com.xing.domain.Department;
import com.xing.domain.PageBean;
import com.xing.domain.Staff;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/24.
 */
public interface AdminService {
    void saveInfo(Department admin);
    Staff login(String name);
    PageBean<Staff> findAll(int pageCode, int pageSize);
    PageBean<Staff> query(int pageCode, int pageSize);

}
