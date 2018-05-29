package com.jingjing.manage.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jingjing.manage.common.Constants;
import com.jingjing.manage.dto.VideoDto;
import com.jingjing.manage.entity.Article;
import com.jingjing.manage.entity.User;
import com.jingjing.manage.entity.Video;
import com.jingjing.manage.param.PageParam;
import com.jingjing.manage.util.AntiXssUtil;
import com.jingjing.manage.dao.VideoDao;
import com.jingjing.manage.redis.RedisUtil;
import com.jingjing.manage.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class VideoServiceImpl implements VideoService {


    @Autowired
    VideoDao videoDao;
    @Autowired
    RedisUtil redisUtil;
    @Override
    public PageInfo<VideoDto> list(PageParam param) {
        if (param.getPage()==null||param.getPage().equals("")||param.getPageSize()==null||param.getPageSize().equals("")){
            return null;
        }
        PageHelper.startPage(param.getPage(),param.getPageSize());
        PageInfo<VideoDto> videoPageInfo=new PageInfo<>(videoDao.selectAll());
        return videoPageInfo;
    }

    @Override
    public int deleteVideo(Integer id) {
        redisUtil.del(Constants.ARTICLE_CACHE_KEY + id);
        return videoDao.delVideo(id);
    }

    @Override
    public int updateVideo(Video video) {
        if (video.getName() == null ) {
            return 0;
        }
        video.setName(AntiXssUtil.replaceHtmlCode(video.getName()));
        if (videoDao.updateVideo(video) > 0) {
            redisUtil.del(Constants.ARTICLE_CACHE_KEY + video.getId());
            redisUtil.put(Constants.ARTICLE_CACHE_KEY + video.getId(), video);
            return 1;
        }
        return 0;
    }

    @Override
    public Video findById(Integer id) {
        Video video = (Video) redisUtil.get(Constants.ARTICLE_CACHE_KEY + id, Video.class);
        if (video != null) {
            return video;
        }
        Video videoFromMysql = videoDao.getVideoById(id);
        if (videoFromMysql != null) {
            redisUtil.put(Constants.ARTICLE_CACHE_KEY + videoFromMysql.getId(), videoFromMysql);
            return videoFromMysql;
        }
        return null;
    }


    @Override
    public int addVideo(Video video) {
        if (video.getName() == null || video.getVideoUrl() == null || video.getClassifyId()==null || video.getUserId()==null) {
            return 0;
        }
        video.setUpdateTime(new Date());
        video.setName(AntiXssUtil.replaceHtmlCode(video.getName()));
        if (videoDao.insertVideo(video) > 0) {
            redisUtil.put(Constants.ARTICLE_CACHE_KEY + video.getId(), video);
            return 1;
        }
        return 0;
    }
}
