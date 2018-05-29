package service.test;

import com.alibaba.fastjson.JSON;
import com.jingjing.manage.common.ResultGenerator;
import com.jingjing.manage.entity.Article;
import com.jingjing.manage.entity.Picture;
import com.jingjing.manage.service.ArticleService;
import com.jingjing.manage.service.PictureService;
import com.jingjing.manage.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Created by yuanqingjing on 2018/4/14
 */
@RunWith(SpringJUnit4ClassRunner.class) //指定测试用例的运行器 这里是指定了Junit4
@ContextConfiguration("classpath:spring-context.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)//默认回滚,即此类中的方法即使执行成功,数据也并不会真正的修改,方法执行后会回滚.
public class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;

    @Test
    public void findById() {
        System.out.println(articleService.findById(1));

    }
    @Test
    public void articleList() {
      ResultGenerator.genSuccessResult();
//        System.out.println(JSON.toJSON(articleService.articleList(1,10)));
//        Article article = new Article();
//        article.setClassifyId(5);
//        article.setUserId(2);
//        article.setTitle("中国文化");
//        article.setContent("中国文化博大进深");
//        System.out.println(articleService.addArticle(article));
    }
}
