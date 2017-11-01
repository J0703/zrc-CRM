package com.xing.service;

import com.xing.domain.Department;
import com.xing.domain.PageBean;
import com.xing.domain.Staff;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/26.
 */
public interface DepartmentService {
    List<Department> findAllDept();
    Department findDeptById(String id);
    PageBean<Department> findPageBean(int pageCode, int pageSize);
    void saveInfo(Department department);
    void updateDept(Department department);
}
