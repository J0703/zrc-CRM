package com.xing.service;

import com.xing.domain.PageBean;
import com.xing.domain.Staff;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 17/10/26.
 */
public interface StaffService {
    void saveStaff(Staff staff);
    Staff findStaffById(String staffId);
    PageBean<Staff> findAll(int pageCode, int pageSize);
    PageBean<Staff> query(int pageCode, int pageSize);
    PageBean<Staff> higherQuery(int pageCode, int pageSize, Map<String,Object> params);
    Staff login(String name);
}
