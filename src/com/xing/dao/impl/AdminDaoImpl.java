package com.xing.dao.impl;

import com.xing.dao.AdminDao;
import com.xing.domain.Admin;
import com.xing.domain.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by dllo on 17/10/24.
 */
public class AdminDaoImpl extends BaseDaoImpl<Department> implements AdminDao {

}
