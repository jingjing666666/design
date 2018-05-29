package com.jingjing.manage.service;

import com.github.pagehelper.PageInfo;
import com.jingjing.manage.dto.PictureDto;
import com.jingjing.manage.entity.Article;
import com.jingjing.manage.entity.Picture;

import java.util.List;
import java.util.Map;
/**
 * Created by yuanqingjing on 2018/4/12
 */
public interface PictureService {
	/**
	 * 返回相应的数据集合
	 * 
	 * @param map
	 * @return
	 */
	public List<Picture> findPicture(Map<String, Object> map);

	/**
	 * 数据数目
	 * 
	 * @param map
	 * @return
	 */
	public Long getTotalPicture(Map<String, Object> map);

	/**
	 * 添加图片
	 * 
	 * @param picture
	 * @return
	 */
	public int addPicture(Picture picture);

	/**
	 * 修改图片
	 * 
	 * @param picture
	 * @return
	 */
	public int updatePicture(Picture picture);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public int deletePicture(Integer id);

	/**
	 * 根据id查找
	 * 
	 * @param id
	 * @return
	 */
	public Picture findById(Integer id);

	PageInfo<PictureDto> pictureList(Integer page, Integer pageSize, Integer type);
}
