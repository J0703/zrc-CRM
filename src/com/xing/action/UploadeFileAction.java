package com.xing.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xing.domain.Schedule;
import com.xing.service.ScheduleService;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.File;
import java.io.IOException;

/**
 * Created by dllo on 17/11/1.
 */
public class UploadeFileAction  extends ActionSupport {
    @Autowired
    @Qualifier("scheduleService")
    private ScheduleService scheduleService;
    // 表单提交过来的文件,名字与jsp页面的name同名
    private File[] photo;
    private String[] photoFileName;// 提交文件对应的文件名
    private String[] photoContentType ;// 提交的文件对应的格式,例如:png
    /**
     * 单个文件上传
     **/
    public String singleUpload(){
        String path = ServletActionContext.getServletContext().getRealPath("files");
        path = path.substring(0,path.indexOf("out"));
        path = path + "web/images";
        File destFile = new File(path);
        // 如果目的文件不存在,则需要创建一下该目录
        if (!destFile.exists()||!destFile.isDirectory()){
            destFile.mkdirs();
        }
        // 构建一个空文件对象,用于存储上传文件
        for(int i=0;i<photo.length;i++){
            File file = new File(destFile,photoFileName[i]);
            try {
                FileUtils.copyFile(photo[i],file);
                Schedule schedule = new Schedule();
                schedule.setUploadFileName(photoFileName[i]);
                schedule.setUploadPath(path);
                scheduleService.saveInfo(schedule);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return SUCCESS;
    }

    public File[] getPhoto() {
        return photo;
    }

    public void setPhoto(File[] photo) {
        this.photo = photo;
    }

    public String[] getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String[] photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String[] getPhotoContentType() {
        return photoContentType;
    }

    public void setPhotoContentType(String[] photoContentType) {
        this.photoContentType = photoContentType;
    }
}

