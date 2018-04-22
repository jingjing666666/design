package com.jingjing.manage.service.impl;


import com.jingjing.manage.common.Constants;
import com.jingjing.manage.entity.Video;
import com.jingjing.manage.util.AntiXssUtil;
import com.jingjing.manage.dao.VideoDao;
import com.jingjing.manage.redis.RedisUtil;
import com.jingjing.manage.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoDao videoDao;
    @Autowired
    RedisUtil redisUtil;

    @Override
    public int deleteVideo(String id) {
        redisUtil.del(Constants.ARTICLE_CACHE_KEY + id);
        return videoDao.delVideo(id);
    }

    @Override
    public int updateVideo(Video video) {
        if (video.getName() == null || video.getVideoUrl() == null || video.getClassify()==null || video.getUserId()==null) {
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
    public Video findById(String id) {
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
        if (video.getName() == null || video.getVideoUrl() == null || video.getClassify()==null || video.getUserId()==null) {
            return 0;
        }
        video.setName(AntiXssUtil.replaceHtmlCode(video.getName()));
        if (videoDao.insertVideo(video) > 0) {
            redisUtil.put(Constants.ARTICLE_CACHE_KEY + video.getId(), video);
            return 1;
        }
        return 0;
    }
}
