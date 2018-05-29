package com.jingjing.manage.service;

import com.github.pagehelper.PageInfo;
import com.jingjing.manage.dto.VideoDto;
import com.jingjing.manage.entity.Article;
import com.jingjing.manage.entity.Video;
import com.jingjing.manage.param.PageParam;

/**
 * Created by yuanqingjing on 2018/4/12
 */
public interface VideoService {
    int addVideo(Video video);


    Video findById(Integer id);

    int updateVideo(Video video);

    int deleteVideo(Integer id);

    PageInfo<VideoDto> list(PageParam param);
}
