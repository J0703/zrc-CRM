package com.xing.service;

import com.xing.domain.PageBean;
import com.xing.domain.Post;
import com.xing.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/10/26.
 */
public interface PostService {
    List<Post> findAllPost();
    Post findPostByPid(String pId);
    List<Post> findPostsByDid(String dId);
    PageBean<Post> findAll(int pageCode, int pageSize);
    PageBean<Post> query(int pageCode, int pageSize);
    void saveInfo(Post post);
    void updatePost(Post post);
}
