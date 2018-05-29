package dao.test;

import com.alibaba.fastjson.JSON;
import com.jingjing.manage.dao.ArticleDao;
import com.jingjing.manage.entity.Article;
import com.jingjing.manage.param.PageParam;
import com.jingjing.manage.util.DateUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by 13 on 2018/1/17.
 */
@RunWith(SpringJUnit4ClassRunner.class) //指定测试用例的运行器 这里是指定了Junit4
@ContextConfiguration("classpath:spring-context.xml")
public class ArticleDaoTest {
    @Autowired
    private ArticleDao articleDao;

    @Test
    public void insertArticleTest() throws Exception {
        PageParam pageParam = new PageParam();
        pageParam.setPage(1);
        pageParam.setPageSize(10);
        pageParam.setType(8);

        System.out.println(JSON.toJSON(articleDao.selectAll(pageParam)));
    }
    @Test
    public void articleTest(){

    }

}
