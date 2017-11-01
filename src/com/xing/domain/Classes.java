package com.xing.domain;

import java.util.Date;

/**
 * 班级
 * @author zrc
 */
public class Classes {
    /**主键Id*/
    private String classId;
    /**所属课程Id*/
    private Course course;
    /**课程表*/
    private Schedule schedule;
    /**班级名称*/
    private String name;
    /**开班时间*/
    private Date beginTime;
    /**毕业时间*/
    private Date endTime;
    /**学生总数*/
    private int totalCount;
    /**升班数*/
    private int upgradeCount;
    /**转班数*/
    private int changeCount;
    /**退费数*/
    private int runoffCount;
    /**其他说明*/
    private String remark;

    public Classes() {
    }

    public Classes(String name, Date beginTime, Date endTime, int totalCount, int upgradeCount, int changeCount, int runoffCount) {
        this.name = name;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.totalCount = totalCount;
        this.upgradeCount = upgradeCount;
        this.changeCount = changeCount;
        this.runoffCount = runoffCount;
    }

    public Classes(String name) {
        this.name = name;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getUpgradeCount() {
        return upgradeCount;
    }

    public void setUpgradeCount(int upgradeCount) {
        this.upgradeCount = upgradeCount;
    }

    public int getChangeCount() {
        return changeCount;
    }

    public void setChangeCount(int changeCount) {
        this.changeCount = changeCount;
    }

    public int getRunoffCount() {
        return runoffCount;
    }

    public void setRunoffCount(int runoffCount) {
        this.runoffCount = runoffCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
