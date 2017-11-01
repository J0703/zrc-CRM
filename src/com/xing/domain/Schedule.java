package com.xing.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 课表
 */
public class Schedule {
    /**课程表主键*/
    private String scId;
    /**课表路径*/
    private String uploadPath;
    /**课表名称*/
    private String uploadFileName;
    /**上传时间*/
    private String uploadTime;

    /**用这张课表的班级*/
    private Set<Classes> classes = new HashSet<>();

    public Schedule() {
    }

    public Schedule(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getScId() {
        return scId;
    }

    public void setScId(String scId) {
        this.scId = scId;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Set<Classes> getClasses() {
        return classes;
    }

    public void setClasses(Set<Classes> classes) {
        this.classes = classes;
    }
}
