package com.xing.dao;

import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
public interface FindPageDao<T> extends BaseDao<T>{
    List<T> findPage(String hql,int pageCode,int pageSize);
}
