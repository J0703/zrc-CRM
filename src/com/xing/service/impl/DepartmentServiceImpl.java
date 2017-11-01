package com.xing.service.impl;

import com.xing.dao.DepartmentDao;
import com.xing.domain.Department;
import com.xing.domain.PageBean;
import com.xing.domain.Staff;
import com.xing.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/26.
 * @author 123
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    @Qualifier("departmentDao")
    private DepartmentDao departmentDao;

    @Override
    public List<Department> findAllDept() {
        String hql = "from Department";
        return departmentDao.find(hql,null);
    }

    @Override
    public Department findDeptById(String id) {
        String hql = "from Department WHERE depId=:id";
        Map<String ,Object> params = new HashMap<>(10);
        params.put("id",id);
        return departmentDao.find(hql,params).get(0);
    }

    @Override
    public PageBean<Department> findPageBean(int pageCode, int pageSize) {
        PageBean<Department> pb = new PageBean<>();
        StringBuilder hql = new StringBuilder();
        hql.append("from Department");
        List<Department> departments = departmentDao.findPage(hql.toString(),pageCode,pageSize);
        pb.setBeanlist(departments);
        return pb;
    }

    @Override
    public void saveInfo(Department department) {
        departmentDao.saveInfo(department);
    }

    @Override
    public void updateDept(Department department) {
        departmentDao.updateInfo(department);
    }
}
