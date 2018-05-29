package dao.test;

import com.jingjing.manage.dao.PictureDao;
import com.jingjing.manage.entity.Picture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 13 on 2017/3/30.
 */
@RunWith(SpringJUnit4ClassRunner.class) //指定测试用例的运行器 这里是指定了Junit4
@ContextConfiguration("classpath:spring-context.xml")
public class PictureDaoTest {
    @Autowired
    private PictureDao pictureDao;

    @Test
    public void insertPictureTest() {
        Picture picture = null;
        for (int i = 1; i < 20; i++) {
            for (int j = 1; j < 20; j++) {
                picture = new Picture();
                picture.setType(j );
//                picture.setGrade(i + "");
                picture.setPath("upload/20170425_1714107.jpg");
                SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try{
                    Date date = dateFormat.parse("2017-08-21 12:22:32");
                    picture.setCreateTime(new Date());
                }catch (Exception e){

                }

                picture.setUrl("url");
                pictureDao.insertPicture(picture);
            }
        }
    }

}
