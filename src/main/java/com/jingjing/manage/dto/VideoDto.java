package com.jingjing.manage.dto;

import com.jingjing.manage.entity.Video;

/**
 * Created by yuanqingjing on 2018/5/4
 */
public class VideoDto extends Video {
    /**
     * 发布人
     */
    private String user;
    /**
     * 分类名称
     */
    private String classifyName;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }



}
