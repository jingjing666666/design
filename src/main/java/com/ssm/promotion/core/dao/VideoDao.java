package com.ssm.promotion.core.dao;

import com.ssm.promotion.core.entity.Video;
import java.util.List;

public interface VideoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    Video selectByPrimaryKey(Integer id);

    List<Video> selectAll();

    int updateByPrimaryKey(Video record);
}