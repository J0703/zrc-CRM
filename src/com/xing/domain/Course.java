package com.xing.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 课程
 */
public class Course {
    /**主键Id*/
    private String couId;
    /**课程类别名称*/
    private String couName;
    /**课程费用*/
    private double couCost;
    /**总课时*/
    private int total;
    /**课程介绍模板*/
    private String remark;

    /**课程下面的班级*/
    private Set<Classes> classes = new HashSet<>();

    public Course() {
    }

    public Course(String couName, double couCost, int total) {
        this.couName = couName;
        this.couCost = couCost;
        this.total = total;
    }

    public String getCouId() {
        return couId;
    }

    public void setCouId(String couId) {
        this.couId = couId;
    }

    public double getCouCost() {
        return couCost;
    }

    public void setCouCost(double couCost) {
        this.couCost = couCost;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCouName() {
        return couName;
    }

    public void setCouName(String couName) {
        this.couName = couName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set<Classes> getClasses() {
        return classes;
    }

    public void setClasses(Set<Classes> classes) {
        this.classes = classes;
    }
}
