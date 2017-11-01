package com.xing.service.impl;

import com.xing.dao.PostDao;
import com.xing.domain.PageBean;
import com.xing.domain.Post;
import com.xing.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/26.
 */
@Service("postService")
public class PostServiceImpl implements PostService {
    @Autowired
    @Qualifier("postDao")
    private PostDao postDao;

    @Override
    public List<Post> findAllPost() {
        String hql = "from Post";
        return postDao.find(hql,null);
    }

    @Override
    public Post findPostByPid(String pId) {
        String hql = "from Post WHERE postId=:pId";
        Map<String,Object> params = new HashMap<>();
        params.put("pId",pId);
        return postDao.find(hql,params).get(0);
    }

    @Override
    public List<Post> findPostsByDid(String dId) {
        String hql = "from Post WHERE depId=:dId";
        Map<String,Object> params = new HashMap<>();
        params.put("dId",dId);
        return postDao.find(hql,params);
    }

    @Override
    public PageBean<Post> findAll(int pageCode, int pageSize) {
        PageBean<Post> pb = new PageBean<>();
        pb.setPageCode(pageCode);
        pb.setPageSize(pageSize);
        String hql = "from Staff";
        List<Post> staffs = postDao.findPage(hql,pageCode,pageSize);
        String hql2 = "select count(*) from Staff";
        pb.setTotalRecode(postDao.allCount(hql2));
        pb.setBeanlist(staffs);
        return pb;
    }

    @Override
    public PageBean<Post> query(int pageCode, int pageSize) {
        return null;
    }

    @Override
    public void saveInfo(Post post) {
        postDao.saveInfo(post);
    }

    @Override
    public void updatePost(Post post) {
        postDao.updateInfo(post);
    }

    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }
}
