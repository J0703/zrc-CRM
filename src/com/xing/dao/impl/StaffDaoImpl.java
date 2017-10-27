package com.xing.dao.impl;

import com.xing.dao.BaseDao;
import com.xing.dao.FindPageDao;
import com.xing.dao.StaffDao;
import com.xing.domain.Staff;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/25.
 */
public class StaffDaoImpl extends BaseDaoImpl<Staff> implements StaffDao {
    @Override
    public List<Staff> findPage(String hql, int pageCode, int pageSize) {
        Session session = currentSession();
        int start = (pageCode - 1) * pageSize ;
        Query query = session.createQuery(hql).setFirstResult(start).setMaxResults(pageSize);
        List<Staff> tList = query.list();
        return tList;// 返回查询结果集
    }

    @Override
    public List<Staff> higherFind(String sql, Map<String,Object> params) {
        Session session = currentSession();
        System.out.println(sql);
        SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(Staff.class);
        if (params != null && !params.isEmpty()){
            for (String key : params.keySet()) {
                System.out.println(key);
                sqlQuery.setParameter(key,params.get(key));
            }
        }
        List<Staff> staffs = sqlQuery.list();
        return staffs;
    }
}
