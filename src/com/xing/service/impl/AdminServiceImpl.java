package com.xing.service.impl;

import com.xing.dao.AdminDao;
import com.xing.dao.PostDao;
import com.xing.dao.StaffDao;
import com.xing.domain.Admin;
import com.xing.domain.Department;
import com.xing.domain.PageBean;
import com.xing.domain.Staff;
import com.xing.service.AdminService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/24.
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    @Qualifier("adminDao")
    private AdminDao adminDao;
    @Autowired
    @Qualifier("staffDao")
    private StaffDao staffDao;
    @Autowired
    @Qualifier("postDao")
    private PostDao postDao;
    @Override
    public void saveInfo(Department admin) {
        adminDao.saveInfo(admin);
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

    public List<Staff> findAll() {
        String hql = "from Staff";
        List<Staff> staffs = staffDao.find(hql,null);
        if (staffs.size() == 0){
            return null;
        }
        String hql1 = "from Post WHERE postId=:id";
        for (Staff staff : staffs) {
            Map<String,Object> params = new HashMap<>(10);
            params.put("id",staff.getPostId());
            staff.setPost(postDao.find(hql1,params).get(0));
        }
        return staffs;
    }

}
