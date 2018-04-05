package com.ssm.promotion.core.dao;

import com.ssm.promotion.core.entity.Video;
import java.util.List;

public interface VideoDao {
    int updateVideo(Video video);

    List<Video> selectAll();


    int delVideo(String id);

    int insertVideo(Video video);

    Video getVideoById(String id);
}