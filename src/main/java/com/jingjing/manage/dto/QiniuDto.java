package com.jingjing.manage.dto;

/**
 * Created by yuanqingjing on 2018/5/7
 */
public class QiniuDto {
     public String bucket;
     public String uptoken;
     public String path;

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getUptoken() {
        return uptoken;
    }

    public void setUptoken(String uptoken) {
        this.uptoken = uptoken;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


}
