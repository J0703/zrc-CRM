package com.xing.dao.impl;

import com.xing.dao.BaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/24.
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;
    @Override
    public void saveInfo(T t) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(t);
        transaction.commit();
    }

    @Override
    public T findById(Serializable id, Class<T> tClass) {
        return null;
    }


    @Override
    public List<T> find(String hql, Map<String, Object> params) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(hql).setFirstResult(0).setMaxResults(3);
        if (params != null && !params.isEmpty()){
            for (String key : params.keySet()) {
                query.setParameter(key,params.get(key));
            }
        }
        List<T> tList = query.list();
        transaction.commit();
        return tList;// 返回查询结果集
    }

    @Override
    public int allCount(String hql) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(hql);
        System.out.println(query.uniqueResult());
        Number num = (Number)query.uniqueResult();
        transaction.commit();
        return num.intValue();
    }

}
