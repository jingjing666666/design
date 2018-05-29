package com.jingjing.manage.dao;

import com.jingjing.manage.entity.Article;
import com.jingjing.manage.entity.Classify;

import java.util.List;
/**
 * Created by yuanqingjing on 2018/4/10
 */
public interface ClassifyDao {




    List<Classify> selectAll();

    /**
     * 添加分类
     *
     * @return
     */
    public int insertClassify(Classify classify);

    /**
     * 修改分类
     *
     * @return
     */
    public int updClassify(Classify classify);

    /**
     * 删除分类
     *
     * @param id
     * @return
     */
    public int delClassify(Integer id);

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    public Classify getClassifyById(Integer id);
    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    public List<Classify> getLevel(Integer id);

    List<Classify> findchildren(Integer id);
}