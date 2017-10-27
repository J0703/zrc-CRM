package com.xing.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/24.
 */
public interface BaseDao<T> {
    /**
     * 保存信息
     * @param t 需要保存的信息载体
     */
    void saveInfo(T t);

    /**
     * 根据主键id查询某个对象
     * @param id 要查询的id
     * @param tClass 返回对象的类声明
     * @return
     */
    T findById(Serializable id,Class<T> tClass);

    /**
     * 根据条件查询
     * @param hql 查询语句
     * @param params 查询语句的参数列表
     * @return 返回查询集合
     */
    List<T> find(String hql, Map<String, Object> params);
    int allCount(String hql);
    int higherFindCount(String sql,Map<String,Object> params);
}
