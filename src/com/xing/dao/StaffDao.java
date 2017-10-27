package com.xing.dao;

import com.xing.domain.Staff;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/25.
 */
public interface StaffDao extends FindPageDao<Staff> {
    List<Staff> higherFind(String sql, Map<String,Object> params);

}
