package com.jingjing.manage.service;

import com.github.pagehelper.PageInfo;
import com.jingjing.manage.dto.ArticleDto;
import com.jingjing.manage.entity.Article;
import com.jingjing.manage.param.PageParam;

import java.util.List;
import java.util.Map;

/**
 * Created by yuanqingjing on 2018/4/12
 */
public interface ArticleService {
	/**
	 * 返回相应的数据集合
	 *
	 * @param map
	 * @return
	 */
	public List<Article> findArticle(Map<String, Object> map);

	/**
	 * 数据数目
	 *
	 * @param map
	 * @return
	 */
	public Long getTotalArticle(Map<String, Object> map);

	/**
	 * 添加文章
	 * 
	 * @param article
	 * @return
	 */
	public int addArticle(Article article);

	/**
	 * 修改文章
	 * 
	 * @param article
	 * @return
	 */
	public int updateArticle(Article article);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public int deleteArticle(Integer id);

	/**
	 * 根据id查找
	 * 
	 * @param id
	 * @return
	 */
	public Article findById(Integer id);

	PageInfo<ArticleDto> articleList(PageParam page);

//    PageInfo<ArticleDto> articleList(Integer page, Integer pageSize,Integer type);
}
