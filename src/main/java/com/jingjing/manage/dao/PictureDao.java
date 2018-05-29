package com.jingjing.manage.dao;

import com.jingjing.manage.dto.PictureDto;
import com.jingjing.manage.entity.Article;
import com.jingjing.manage.entity.Picture;

import java.util.List;
import java.util.Map;

/**
 * Created by yuanqingjing on 2018/4/10
 */
public interface PictureDao {
    /**
     * 返回相应的数据集合
     *
     * @param map
     * @return
     */
    public List<Picture> findPictures(Map<String, Object> map);

    /**
     * 数据数目
     *
     * @param map
     * @return
     */
    public Long getTotalPictures(Map<String, Object> map);

    /**
     * 添加图片
     *
     * @param picture
     * @return
     */
    public int insertPicture(Picture picture);

    /**
     * 修改图片
     *
     * @param picture
     * @return
     */
    public int updPicture(Picture picture);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public int delPicture(Integer id);

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    public Picture findPictureById(Integer id);

    /**
     * 查找文章列表
     * @return
     */
    List<PictureDto> selectAll(Integer type);
}
