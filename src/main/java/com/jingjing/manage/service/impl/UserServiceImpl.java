package com.jingjing.manage.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jingjing.manage.entity.Article;
import com.jingjing.manage.service.UserService;
import com.jingjing.manage.util.AntiXssUtil;
import com.jingjing.manage.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jingjing.manage.dao.UserDao;

/**
 * @author 1034683568@qq.com
 * @project_name perfect-ssm
 * @date 2017-3-1
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    public List<User> findUser(Map<String, Object> map) {
        return userDao.findUsers(map);
    }

    @Override
    public int updateUser(User user) {
        //防止有人胡乱修改导致其他人无法正常登陆
        if ("web".equals(user.getUserName())) {
            return 0;
        }
        User u = userDao.findUserById(user.getId());
        System.out.println("user u" +u.getId());
        u.setUserName(user.getUserName());
        u.setPassword(user.getPassword());
        u.setDeleted(user.getDeleted());
        return userDao.updateUser(u);
    }

    @Override
    public Long getTotalUser(Map<String, Object> map) {
        return userDao.getTotalUser(map);
    }

    @Override
    public int addUser(User user) {
        if (user.getUserName() == null || user.getPassword() == null || getTotalUser(null) > 90) {
            return 0;
        }
        user.setUserName(AntiXssUtil.replaceHtmlCode(user.getUserName()));
        return userDao.addUser(user);
    }

    @Override
    public int deleteUser(Integer id) {
        //防止有人胡乱修改导致其他人无法正常登陆
        if (2 == id) {
            return 0;
        }
        return userDao.deleteUser(id);
    }

    @Override
    public PageInfo<User> list(Integer page, Integer pageSize) {
        if (page==null||page.equals("")||pageSize==null||pageSize.equals("")){
            return null;
        }
        PageHelper.startPage(page,pageSize);
        PageInfo<User> articlePageInfo=new PageInfo<>(userDao.selectAll());
        return articlePageInfo;
    }
}
