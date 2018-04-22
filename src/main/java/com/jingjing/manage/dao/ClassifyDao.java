package com.jingjing.manage.dao;

import com.jingjing.manage.entity.Classify;

import java.util.List;
/**
 * Created by yuanqingjing on 2018/4/10
 */
public interface ClassifyDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Classify record);

    Classify selectByPrimaryKey(Integer id);

    List<Classify> selectAll();

    int updateByPrimaryKey(Classify record);
}