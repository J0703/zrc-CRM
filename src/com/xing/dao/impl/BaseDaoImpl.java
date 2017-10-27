package com.xing.dao.impl;

import com.xing.dao.BaseDao;
import com.xing.domain.Staff;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/24.
 */
public class BaseDaoImpl<T>  extends HibernateDaoSupport implements BaseDao<T> {

    @Override
    public void saveInfo(T t) {
        Session session = currentSession();
        session.save(t);
    }

    @Override
    public T findById(Serializable id, Class<T> tClass) {
        return null;
    }


    @Override
    public List<T> find(String hql, Map<String, Object> params) {
        Session session = currentSession();
        Query query = session.createQuery(hql).setFirstResult(0).setMaxResults(3);
        if (params != null && !params.isEmpty()){
            for (String key : params.keySet()) {
                query.setParameter(key,params.get(key));
            }
        }
        List<T> tList = query.list();
        return tList;// 返回查询结果集
    }

    @Override
    public int allCount(String hql) {
        Session session = currentSession();
        Query query = session.createQuery(hql);
        System.out.println(query.uniqueResult());
        Number num = (Number)query.uniqueResult();
        System.out.println(num);
        return num.intValue();
    }

    @Override
    public int higherFindCount(String sql,Map<String,Object> params) {
        Session session = currentSession();
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        if (params != null && !params.isEmpty()){
            for (String key : params.keySet()) {
                System.out.println(params.get(key));
                sqlQuery.setParameter(key,params.get(key));
            }
        }
        Number num = (Number)sqlQuery.uniqueResult();
        System.out.println(num);
        return num.intValue();
    }

}
