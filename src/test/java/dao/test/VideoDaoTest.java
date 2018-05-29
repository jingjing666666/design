package dao.test;

import com.jingjing.manage.dao.VideoDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class) //指定测试用例的运行器 这里是指定了Junit4
@ContextConfiguration("classpath:spring-context.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)//默认回滚,即此类中的方法即使执行成功,数据也并不会真正的修改,方法执行后会回滚.
public class VideoDaoTest {
    @Autowired
    VideoDao videoDao;
    @Test
    public void test(){
        videoDao.delVideo(1);
    }
}
