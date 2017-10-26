package com.xing.dao.impl;

import com.xing.dao.PostDao;
import com.xing.domain.Post;
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
public class PostDaoImpl extends BaseDaoImpl<Post> implements PostDao {

    @Override
    public List<Post> findPage(String hql, int pageCode, int pageSize) {
        Session session = currentSession();
        int start = (pageCode - 1) * pageSize ;
        Query query = session.createQuery(hql).setFirstResult(start).setMaxResults(pageSize);
        List<Post> tList = query.list();
        return tList;// 返回查询结果集
    }
}
