package com.xing.service.impl;

import com.xing.dao.StaffDao;
import com.xing.domain.PageBean;
import com.xing.domain.Staff;
import com.xing.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/26.
 */
@Service("staffService")
public class StaffServiceImpl implements StaffService {
    @Autowired
    @Qualifier("staffDao")
    private StaffDao staffDao;

    @Override
    public void saveStaff(Staff staff) {
        staffDao.saveInfo(staff);
    }

    @Override
    public Staff findStaffById(String staffId) {
        String hql = "from Staff where staffId=:staffId";
        Map<String,Object> params = new HashMap<>(10);
        params.put("staffId",staffId);
        return staffDao.find(hql,params).get(0);
    }

    @Override
    public PageBean<Staff> findAll(int pageCode, int pageSize) {
        PageBean<Staff> pb = new PageBean<>();
        pb.setPageCode(pageCode);
        pb.setPageSize(pageSize);
        String hql = "from Staff";
        List<Staff> staffs = staffDao.findPage(hql,pageCode,pageSize);
        String hql2 = "select count(*) from Staff";
        pb.setTotalRecode(staffDao.allCount(hql2));
        pb.setBeanlist(staffs);
        return pb;
    }

    @Override
    public PageBean<Staff> query(int pageCode, int pageSize) {
        return null;
    }

    @Override
    public Staff login(String name) {
        String hql = "from Staff where loginName=:name";
        Map<String,Object> params = new HashMap<>(10);
        params.put("name",name);
        List<Staff> staffs = staffDao.find(hql,params);
        if (staffs.size() == 0){
            return null;
        }
        return staffs.get(0);
    }

}