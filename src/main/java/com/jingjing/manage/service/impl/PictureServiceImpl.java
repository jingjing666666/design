package com.jingjing.manage.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jingjing.manage.dao.PictureDao;
import com.jingjing.manage.dto.PictureDto;
import com.jingjing.manage.entity.Article;
import com.jingjing.manage.entity.Picture;
import com.jingjing.manage.service.PictureService;
import com.jingjing.manage.util.AntiXssUtil;
import org.springframework.stereotype.Service;


@Service("pictureService")
public class PictureServiceImpl implements PictureService {
    @Resource
    private PictureDao pictureDao;

    @Override
    public List<Picture> findPicture(Map<String, Object> map) {
        return pictureDao.findPictures(map);
    }

    @Override
    public Long getTotalPicture(Map<String, Object> map) {
        return pictureDao.getTotalPictures(map);
    }

    @Override
    public int addPicture(Picture picture) {
        if (picture.getPath() == null ) {
            return 0;
        }
        picture.setPath(AntiXssUtil.replaceHtmlCode(picture.getPath()));
        picture.setCreateTime(new Date());

        return pictureDao.insertPicture(picture);
    }

    @Override
    public int updatePicture(Picture picture) {
        if (picture.getPath() == null) {

            return 0;
        }
//        picture.setUrl(AntiXssUtil.replaceHtmlCode(picture.getUrl()));
        System.out.println(picture.getPath()+"picture url");
        return pictureDao.updPicture(picture);
    }

    @Override
    public int deletePicture(Integer id) {
        return pictureDao.delPicture(id);
    }

    @Override
    public Picture findById(Integer id) {
        return pictureDao.findPictureById(id);
    }

    @Override
    public PageInfo<PictureDto> pictureList(Integer page, Integer pageSize, Integer type) {
        if (page==null||page.equals("")||pageSize==null||pageSize.equals("")){
            return null;
        }
        PageHelper.startPage(page,pageSize);
        PageInfo<PictureDto> articlePageInfo=new PageInfo<>(pictureDao.selectAll(type));
        return articlePageInfo;
    }



}
