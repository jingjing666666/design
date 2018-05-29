package com.jingjing.manage.dao;

import com.jingjing.manage.dto.VideoDto;
import com.jingjing.manage.entity.Video;
import com.jingjing.manage.param.PageParam;

import java.util.List;
/**
 * Created by yuanqingjing on 2018/4/10
 */
public interface VideoDao {
    /**
     * 更新视频
     * @param video
     * @return
     */
    int updateVideo(Video video);

    /**
     * 查找所有视频
     * @return
     */
    List<VideoDto> selectAll();
    /**
     * 删除某个视频
     * @param id
     * @return
     */
    int delVideo(Integer id);

    /**
     * 增加视频
     * @param video
     * @return
     */
    int insertVideo(Video video);

    /**
     * 查找某个视频
     * @param id
     * @return
     */
    Video getVideoById(Integer id);
}