package com.jingjing.manage.dao;

import com.jingjing.manage.dto.ArticleDto;
import com.jingjing.manage.entity.Article;
import com.jingjing.manage.param.PageParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * Created by yuanqingjing on 2018/4/10
 */
public interface ArticleDao {
	/**
	 * 返回相应的数据集合
	 *
	 * @param map
	 * @return
	 */
	public List<Article> findArticles(Map<String, Object> map);

	/**
	 * 数据数目
	 *
	 * @param map
	 * @return
	 */
	public Long getTotalArticles(Map<String, Object> map);

	/**
	 * 添加文章
	 * 
	 * @return
	 */
	public int insertArticle(Article article);

	/**
	 * 修改文章
	 * 
	 * @return
	 */
	public int updArticle(Article article);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public int delArticle(Integer id);

	/**
	 * 根据id查找
	 * 
	 * @param id
	 * @return
	 */
	public Article getArticleById(Integer id);


	int deleteByPrimaryKey(Integer id);

	int insert(Article record);

	Article selectByPrimaryKey(Integer id);

	List<ArticleDto> selectAll(PageParam param);
	List<ArticleDto> selectAllByType(Integer type);


	int updateByPrimaryKey(Article record);

}
