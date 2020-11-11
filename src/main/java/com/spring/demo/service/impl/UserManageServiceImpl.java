package com.spring.demo.service.impl;

import com.spring.demo.entity.User;
import com.spring.demo.mapper.UserInfoMapper;
import com.spring.demo.service.UserManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Description: 用户管理实现类
 * @Author: Super
 * @CreateDate: 2020/6/24 18:09
 * @Version: 1.0
 */
@Service
@Slf4j
public class UserManageServiceImpl implements UserManageService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public int insertUserInfo(User user) {
        log.info("insertUserInfo, userInfo is {}", user.toString());
        return userInfoMapper.insertUser(user);
    }

	@CacheEvict(value = "user", key = "#id")
    @Override
    public int deleteUser(int id) {
        log.info("deleteUser, userId is {}", id);
        return userInfoMapper.deleteUser(id);
    }

    @CachePut(cacheNames = "user", key = "#result.id")
    @Override
    public int updateUser(User user) {
        log.info("updateUser, id = {}", user.getId());
        return userInfoMapper.updateUser(user);
    }

    @Cacheable(cacheNames = "user", key = "#id")
    @Override
    public User queryUser(Integer id, String phone) {
        log.info("queryUser, userId is {}", id);
        return userInfoMapper.queryUser(id, phone);
    }

    @Override
    public List<User> queryAllUser() {
        log.info("queryAllUser");
        return userInfoMapper.queryAllUser();
    }

    @Override
    public int insertBatch(List<User> users) {
        return userInfoMapper.insertBatch(users);
    }

    @Override
    public int updateBatch(List<User> users) {
        return userInfoMapper.updateBatch(users);
    }

    @Override
    public int deleteBatch(List<Integer> ids) {
        return userInfoMapper.deleteBatch(ids);
    }
}
