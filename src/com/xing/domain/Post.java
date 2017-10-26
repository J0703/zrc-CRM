package com.xing.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/10/25.
 */
public class Post {
    private String postId;
    private String postName;
    private Set<Staff> staffs = new HashSet<>();
    private Department department;

    public Post() {
    }

    public Post(String postName) {
        this.postName = postName;
    }

    public Post(String postId, String postName) {
        this.postId = postId;
        this.postName = postName;

    }

    @Override
    public String toString() {
        return "post{" +
                "postId='" + postId + '\'' +
                ", postName='" + postName + '\'' +
                '}';
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Set<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
