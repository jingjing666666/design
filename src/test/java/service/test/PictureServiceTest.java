package service.test;

import com.jingjing.manage.entity.Picture;
import com.jingjing.manage.service.PictureService;
import com.jingjing.manage.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by 13 on 2017/3/30.
 */
@RunWith(SpringJUnit4ClassRunner.class) //指定测试用例的运行器 这里是指定了Junit4
@ContextConfiguration("classpath:spring-context.xml")
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
//不添加此设置,测试service层的事务管理
//service层与dao层的测试时相同的,不同之处,在于service多数都在配置文件中配置了spring的事务管理
public class PictureServiceTest {
    @Autowired
    private PictureService pictureService;

    @Test
    public void addPictureTest() throws Exception {
        Picture picture = new Picture();
        picture.setPath("path");
        picture.setCreateTime(new Date());
        picture.setUrl("url");
        picture.setType(2);
//        picture.setGrade("1");
        pictureService.addPicture(picture);
    }

}
