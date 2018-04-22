package service.test;

import com.jingjing.manage.entity.Picture;
import com.jingjing.manage.service.ArticleService;
import com.jingjing.manage.service.PictureService;
import com.jingjing.manage.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yuanqingjing on 2018/4/14
 */
@RunWith(SpringJUnit4ClassRunner.class) //指定测试用例的运行器 这里是指定了Junit4
@ContextConfiguration("classpath:spring-context.xml")
public class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;

    @Test
    public void findById() {
        System.out.println(articleService.findById("1"));

    }
}
