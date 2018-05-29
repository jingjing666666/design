package com.jingjing.manage.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.jingjing.manage.entity.User;

/**
 * Created by yuanqingjing on 2018/4/12
 */
public interface UserService {

    /**
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * @param map
     * @return
     */
    public List<User> findUser(Map<String, Object> map);

    /**
     * @param map
     * @return
     */
    public Long getTotalUser(Map<String, Object> map);

    /**
     * @param user
     * @return
     */
    public int updateUser(User user);


    /**
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * @param id
     * @return
     */
    public int deleteUser(Integer id);

    PageInfo<User> list(Integer page, Integer pageSize);
}
