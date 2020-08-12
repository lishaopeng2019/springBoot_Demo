package com.spring.demo.mapper;

import com.spring.demo.entity.Phone;
import com.spring.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    int insertUser(User user);
    int deleteUser(int id);
    int updateUser(User user);
    List<User> queryAllUser();
    User queryUser(Integer id, String phone);
    int insertBatch(List<User> users);
    int updateBatch(List<User> users);
    int deleteBatch(List<Integer> ids);
    int insertPhone(Phone phone);
}
