package com.jingjing.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jingjing.manage.common.Constants;
import com.jingjing.manage.dao.ArticleDao;
import com.jingjing.manage.dto.ArticleDto;
import com.jingjing.manage.param.PageParam;
import com.jingjing.manage.service.ArticleService;
import com.jingjing.manage.util.AntiXssUtil;
import com.jingjing.manage.entity.Article;
import com.jingjing.manage.redis.RedisUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class ArticleServiceImpl implements ArticleService {

    private static final Logger log = Logger.getLogger(ArticleService.class);

    @Resource
    private ArticleDao articleDao;
    @Resource
    private RedisUtil redisUtil;

    @Override
    public List<Article> findArticle(Map<String, Object> map) {
        return articleDao.findArticles(map);
    }

    @Override
    public Long getTotalArticle(Map<String, Object> map) {
        return articleDao.getTotalArticles(map);
    }

    /**
     * 添加一篇文章
     * @param article
     * @return
     */
    @Override
    public int addArticle(Article article) {
        if (article.getTitle() == null || article.getContent() == null  || article.getContent().length() > 50000) {
            return 0;
        }
        article.setCreateTime(new Date());
        article.setTitle(AntiXssUtil.replaceHtmlCode(article.getTitle()));
        if (articleDao.insertArticle(article) > 0) {
            log.info("insert article success,save article to redis");
            redisUtil.put(Constants.ARTICLE_CACHE_KEY + article.getId(), article);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateArticle(Article article) {
        if (article.getTitle() == null || article.getContent() == null || article.getClassifyId()==null) {
            return 0;
        }
        article.setTitle(AntiXssUtil.replaceHtmlCode(article.getTitle()));
        if (articleDao.updArticle(article) > 0) {
            log.info("update article success,delete article in redis and save again");
            redisUtil.del(Constants.ARTICLE_CACHE_KEY + article.getId());
            redisUtil.put(Constants.ARTICLE_CACHE_KEY + article.getId(), article);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteArticle(Integer  id) {
        redisUtil.del(Constants.ARTICLE_CACHE_KEY + id);
        return articleDao.delArticle(id);
    }

    @Override
    public Article findById(Integer id) {
        log.info("get article by id:" + id);
        Article article = (Article) redisUtil.get(Constants.ARTICLE_CACHE_KEY + id, Article.class);
        if (article != null) {
            log.info("article in redis");
            return article;
        }
        Article articleFromMysql = articleDao.getArticleById(id);
        if (articleFromMysql != null) {
            log.info("get article from mysql and save article to redis");
            redisUtil.put(Constants.ARTICLE_CACHE_KEY + articleFromMysql.getId(), articleFromMysql);
            return articleFromMysql;
        }
        return null;
    }

    @Override
    public PageInfo<ArticleDto> articleList(PageParam page) {
        if (page.getPage()==null||page.getPage().equals("")||page.getPageSize()==null||page.getPageSize().equals("")){
            return null;
        }
        PageHelper.startPage(page.getPage(),page.getPageSize());
        PageInfo<ArticleDto> articlePageInfo=new PageInfo<>(articleDao.selectAll(page));
        return articlePageInfo;
    }

}
