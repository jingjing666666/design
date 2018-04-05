package com.ssm.promotion.core.service;

import com.ssm.promotion.core.entity.Article;
import com.ssm.promotion.core.entity.Video;

public interface VideoService {
    int addVideo(Video video);


    Video findById(String id);

    int updateVideo(Video video);

    int deleteVideo(String s);
}
