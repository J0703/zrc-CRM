package com.xing.dao.impl;

import com.xing.dao.DepartmentDao;
import com.xing.dao.FindPageDao;
import com.xing.domain.Department;
import com.xing.domain.Post;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dllo on 17/10/26.
 */

public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao{

    @Override
    public List<Department> findPage(String hql, int pageCode, int pageSize) {
        Session session = currentSession();
        int start = (pageCode - 1) * pageSize ;
        Query query = session.createQuery(hql).setFirstResult(start).setMaxResults(pageSize);
        List<Department> tList = query.list();
        return tList;// 返回查询结果集
    }
}
