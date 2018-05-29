package com.jingjing.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jingjing.manage.common.Constants;
import com.jingjing.manage.dao.ClassifyDao;
import com.jingjing.manage.entity.Article;
import com.jingjing.manage.entity.Classify;
import com.jingjing.manage.redis.RedisUtil;
import com.jingjing.manage.service.ArticleService;
import com.jingjing.manage.service.ClassifyService;
import com.jingjing.manage.util.AntiXssUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by yuanqingjing on 2018/5/6
 */
@Service("classifyService")
public class ClassifyServiceImpl implements ClassifyService {
    private static final Logger log = Logger.getLogger(ClassifyService.class);
    @Resource
    private RedisUtil redisUtil;



    @Autowired
    ClassifyDao classifyDao;
    @Override
    public PageInfo<Classify> list(Integer page, Integer pageSize) {
        if (page==null||page.equals("")||pageSize==null||pageSize.equals("")){
            return null;
        }
        PageHelper.startPage(page,pageSize);
        PageInfo<Classify> articlePageInfo=new PageInfo<>(classifyDao.selectAll());
        return articlePageInfo;
    }

    @Override
    public Integer addClassify(Classify classify) {
        if (classify.getName() == null ) {
            return 0;
        }
        if (classify.getParentId()==null||classify.getParentId().equals("")){
            classify.setParentId(0);
            classify.setParentIds("0");
            classify.setType(1);
        }else{
            Classify classifyPt=classifyDao.getClassifyById(classify.getParentId());
            classify.setParentIds(classifyPt.getParentIds()+","+String.valueOf(classify.getParentId()));
            Integer level = classify.getParentIds().split(",").length;
            classify.setType(level);
        }

        classify.setCreateTime(new Date());
        classify.setUpdateTime(new Date());
        System.out.println("addClassify");
        if (classifyDao.insertClassify(classify) > 0) {
            log.info("insert classify success,save classify to redis");
            redisUtil.put(Constants.ARTICLE_CACHE_KEY + classify.getId(), classify);
            return 1;
        }
        return 0;
    }

    @Override
    public int updateClassify(Classify classify) {
        if (classify.getName() == null ) {
            return 0;
        }
        Classify classify1=classifyDao.getClassifyById(classify.getId());
        classify1.setName(AntiXssUtil.replaceHtmlCode(classify.getName()));
        classify1.setUpdateTime(new Date());
        if (classifyDao.updClassify(classify1) > 0) {
            log.info("update article success,delete article in redis and save again");
            redisUtil.del(Constants.ARTICLE_CACHE_KEY + classify.getId());
            redisUtil.put(Constants.ARTICLE_CACHE_KEY + classify.getId(), classify);
            return 1;
        }
        return 0;
    }

    @Override
    public void deleteClassify(int id) {
        redisUtil.del(Constants.ARTICLE_CACHE_KEY + id);
        classifyDao.delClassify(id);
    }

    @Override
    public List<Classify> findchildren(Integer id) {
       return classifyDao.findchildren(id);
    }

    @Override
    public Classify findById(Integer id) {
        log.info("get article by id:" + id);
        Classify classify = (Classify) redisUtil.get(Constants.ARTICLE_CACHE_KEY + id, Classify.class);
        if (classify != null) {
            log.info("article in redis");
            return classify;
        }
        Classify classifyFromMysql = classifyDao.getClassifyById(id);
        if (classifyFromMysql != null) {
            log.info("get classify from mysql and save classify to redis");
            redisUtil.put(Constants.ARTICLE_CACHE_KEY + classifyFromMysql.getId(), classifyFromMysql);
            return classifyFromMysql;
        }
        return null;
    }

    @Override
    public List<Classify> getLevel(Integer id) {
        return classifyDao.getLevel(id);
    }
}
