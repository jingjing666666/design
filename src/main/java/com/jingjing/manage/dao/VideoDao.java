package com.jingjing.manage.dao;

import com.jingjing.manage.entity.Video;

import java.util.List;
/**
 * Created by yuanqingjing on 2018/4/10
 */
public interface VideoDao {
    int updateVideo(Video video);

    List<Video> selectAll();


    int delVideo(String id);

    int insertVideo(Video video);

    Video getVideoById(String id);
}