package com.ssm.promotion.core.service.impl;


import com.ssm.promotion.core.common.Constants;
import com.ssm.promotion.core.dao.VideoDao;
import com.ssm.promotion.core.entity.Article;
import com.ssm.promotion.core.entity.Video;
import com.ssm.promotion.core.redis.RedisUtil;
import com.ssm.promotion.core.service.VideoService;
import com.ssm.promotion.core.util.AntiXssUtil;
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
