package com.xing.dao.impl;

import com.xing.dao.PostDao;
import com.xing.domain.Post;
import org.springframework.stereotype.Repository;

/**
 * Created by dllo on 17/10/25.
 */
@Repository("postDao")
public class PostDaoImpl extends BaseDaoImpl<Post> implements PostDao {
}
