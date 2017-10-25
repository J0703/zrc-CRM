package com.xing.dao.impl;

import com.xing.dao.BaseDao;
import com.xing.dao.FindPageDao;
import com.xing.dao.StaffDao;
import com.xing.domain.Staff;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
@Repository("staffDao")
public class StaffDaoImpl extends BaseDaoImpl<Staff> implements StaffDao {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<Staff> findPage(String hql, int pageCode, int pageSize) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        int start = (pageCode - 1) * pageSize ;
        Query query = session.createQuery(hql).setFirstResult(start).setMaxResults(pageSize);
        List<Staff> tList = query.list();
        transaction.commit();
        return tList;// 返回查询结果集
    }

}
