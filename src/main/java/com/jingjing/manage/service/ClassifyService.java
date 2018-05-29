package com.jingjing.manage.service;

import com.github.pagehelper.PageInfo;
import com.jingjing.manage.entity.Article;
import com.jingjing.manage.entity.Classify;

import java.util.List;

/**
 * Created by yuanqingjing on 2018/5/6
 */
public interface ClassifyService {
    PageInfo<Classify> list(Integer page, Integer pageSize);

    Integer addClassify(Classify classify);

    int updateClassify(Classify classify);

    void deleteClassify(int id);

    Classify findById(Integer id);

    List<Classify> getLevel(Integer id);

    List<Classify> findchildren(Integer id);
}
