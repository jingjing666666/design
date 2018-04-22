package com.jingjing.manage.service;

import com.jingjing.manage.entity.Video;
/**
 * Created by yuanqingjing on 2018/4/12
 */
public interface VideoService {
    int addVideo(Video video);


    Video findById(String id);

    int updateVideo(Video video);

    int deleteVideo(String s);
}
