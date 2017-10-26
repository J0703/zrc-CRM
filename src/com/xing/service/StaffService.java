package com.xing.service;

import com.xing.domain.PageBean;
import com.xing.domain.Staff;

/**
 * Created by dllo on 17/10/26.
 */
public interface StaffService {
    void saveStaff(Staff staff);
    Staff findStaffById(String staffId);
    PageBean<Staff> findAll(int pageCode, int pageSize);
    PageBean<Staff> query(int pageCode, int pageSize);
    Staff login(String name);
}
