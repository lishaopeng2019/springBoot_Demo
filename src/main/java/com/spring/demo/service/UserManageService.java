package com.spring.demo.service;

import com.spring.demo.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @Description: 用户管理接口类
 * @Author: Super
 * @CreateDate: 2020/6/24 18:01
 * @Version: 1.0
 */
public interface UserManageService {
    /**
     * 新增单个用户
     */
    int insertUserInfo(User user);
    /**
     * 删除单个用户
     */
    int deleteUser(int id);
    /**
     * 更新单个用户信息
     */
    User updateUser(User user);
    /**
     * 查询单个用户信息
     */
    User queryUser(Integer id, String phone);
    /**
     * 查询所有用户
     */
    List<User> queryAllUser();
    /**
     * 批量增加
     */
    int insertBatch(List<User> users);

    /**
     * 批量更新
     */
    int updateBatch(List<User> users);
	/**
	 * 批量删除
	 */
    int deleteBatch(List<Integer> ids);
}
