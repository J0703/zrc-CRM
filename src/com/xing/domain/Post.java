package com.xing.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/10/25.
 */
public class Post {
    private String postId;
    private String postName;
    private String depId;
    private Set<Staff> staffs = new HashSet<>();
    private Department department;

    public Post() {
    }

    public Post(String postName) {
        this.postName = postName;
    }

    public Post(String postName, String depId) {
        this.postName = postName;
        this.depId = depId;    }

    public Post(String postId, String postName, String depId) {
        this.postId = postId;
        this.postName = postName;
        this.depId = depId;
    }

    @Override
    public String toString() {
        return "post{" +
                "postId='" + postId + '\'' +
                ", postName='" + postName + '\'' +
                ", depId='" + depId + '\'' +
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

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
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
