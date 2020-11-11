package com.spring.demo.controller;

import com.spring.demo.entity.RestResult;
import com.spring.demo.entity.User;
import com.spring.demo.service.UserManageService;
import com.spring.demo.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @Description: 用户管理rest接口类
 * @Author: Super
 * @CreateDate: 2020/6/27 17:31
 * @Version: 1.0
 */
@RestController
@Slf4j
@RequestMapping("/users")
@Api(tags = "用户管理rest接口类") // Api接口文档类注解
public class UsersController {
    @Autowired
    private UserManageService userManageService;

    /**
     * 批量插入
     */
    @PostMapping("/insert/batch")
    @ApiOperation("批量插入用户信息")
    @ApiImplicitParam(name = "users", value = "多个用户信息") // 接口文档参数注解
    public RestResult insertBatch(@RequestBody List<User> users) {
        log.info("request url is /insert/batch, users is {}", users.toString());
        RestResult restResult = new RestResult();
        int insertNum = userManageService.insertBatch(users);
        log.info("users size is {}, insert num is {}", users.size(), insertNum);
        if (insertNum != users.size()) { // sql执行返回结果为执行成功的数据条数，可用此来判断业务执行成功还是失败
            restResult.setStatus(Constants.StatusCode.FAIL_CODE);
            restResult.setErrorMsg("batch insert failed");
        } else {
            restResult.setStatus(Constants.StatusCode.SUCCESS_CODE);
        }
        return restResult;
    }
    /**
     * 新增单个用户信息
     */
    @PostMapping("/insert")
    @ApiOperation("新增单个用户信息")
    @ApiImplicitParam(name = "user", value = "单个用户信息")
    public RestResult insertUserInfo(@RequestBody User user) {
        log.info("request url is /insert, user is {}", user.toString());
        // 此处省略1w行参数校验
//        User user = new User(id, userName, passWord, age, sex, phone);
        RestResult restResult = new RestResult();
        if (userManageService.insertUserInfo(user) < Constants.NumberConstants.INT_ONE) {
            restResult.setStatus(Constants.StatusCode.FAIL_CODE);
            restResult.setErrorMsg("insertUserInfo failed");
        } else {
            restResult.setStatus(Constants.StatusCode.SUCCESS_CODE);
        }
        return restResult;
    }

    /**
     * 删除单个用户信息
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除单个用户信息")
    @ApiImplicitParam(name = "id", value = "用户id")
    public RestResult deleteUser(@PathVariable("id") int userId) {
        log.info("request url is /delete/{}", userId);
        RestResult restResult = new RestResult();
        if (userManageService.deleteUser(userId) < Constants.NumberConstants.INT_ONE) {
            restResult.setStatus(Constants.StatusCode.FAIL_CODE);
            restResult.setErrorMsg("deleteUser failed");
        } else {
            restResult.setStatus(Constants.StatusCode.SUCCESS_CODE);
        }
        return restResult;
    }

    /**
     *更新用户信息,成功返回更新后的用户数据
     */
    @PutMapping("/update")
    @ApiOperation("更新用户信息")
    @ApiImplicitParam(name = "user", value = "单个用户信息")
    public RestResult updateUser(@RequestBody User user) {
        log.info("request url is /update, user is {}", user.toString());
        RestResult restResult = new RestResult();
		if (userManageService.updateUser(user) == Constants.NumberConstants.INT_ONE) {
            restResult.setStatus(Constants.StatusCode.SUCCESS_CODE);
            restResult.setData(user); // user前台传参可以是某几个字段，因此返回的数据只包含更新过的字段
        } else {
            restResult.setStatus(Constants.StatusCode.FAIL_CODE);
            restResult.setErrorMsg("update User failed");
        }
        return restResult;
    }

    /**
     * 使用id或phone查询单个用户信息
     */
    @GetMapping("/query")
    @ApiOperation("查询单个用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id"),
            @ApiImplicitParam(name = "phone", value = "用户手机号码")
    })
    public RestResult queryUser(Integer id, String phone) {
        log.info("request url is /query, id = {}, phone = {}", id, phone);
        RestResult restResult = new RestResult();
        User user = userManageService.queryUser(id, phone);
        if (Objects.isNull(user)) {
            restResult.setStatus(Constants.StatusCode.FAIL_CODE);
            restResult.setErrorMsg("queryUser failed");
            return restResult;
        }
        log.info("query end");
        restResult.setData(user);
        restResult.setStatus(Constants.StatusCode.SUCCESS_CODE);
        return restResult;
    }

    /**
     * 查询所有用户信息
     */
    @GetMapping("/query/all")
    @ApiOperation("查询所有用户信息")
    public RestResult queryAllUser(){
        log.info("request url is /query/all");
        RestResult restResult = new RestResult();
        List<User> users = userManageService.queryAllUser();
        if (Objects.isNull(users)) {
            restResult.setStatus(Constants.StatusCode.FAIL_CODE);
            restResult.setErrorMsg("queryAllUser failed");
            return restResult;
        }
        restResult.setData(users);
        restResult.setStatus(Constants.StatusCode.SUCCESS_CODE);
        return restResult;
    }

    /**
     * 批量更新
     */
    @PutMapping("/update/batch")
    @ApiOperation("批量更新用户信息")
    @ApiImplicitParam(name = "users", value = "多个用户信息")
    public RestResult updateBatch(@RequestBody List<User> users){
        log.info("request url is /update/batch, users is {}", users.toString());
        RestResult restResult = new RestResult();
        int updateNum = userManageService.updateBatch(users);
        log.info("users size is {}, update num is {}", users.size(), updateNum);
        if (updateNum < Constants.NumberConstants.INT_ONE) { // 批量更新不同于插入，它sql执行成功返回的是1
            restResult.setStatus(Constants.StatusCode.FAIL_CODE);
            restResult.setErrorMsg("batch update failed");
        } else {
            restResult.setStatus(Constants.StatusCode.SUCCESS_CODE);
        }
        return restResult;
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    @ApiOperation("批量删除用户信息")
    @ApiImplicitParam(name = "ids", value = "多个用户id", required = true)
    public RestResult deleteBatch(@RequestBody List<Integer> ids) {
        log.info("request url is /delete/batch, ids is {}", ids.toString());
        RestResult restResult = new RestResult();
        int deleteNum = userManageService.deleteBatch(ids);
        log.info("ids size is {}, update num is {}", ids.size(), deleteNum);
        if (deleteNum < Constants.NumberConstants.INT_ONE) { // 批量更新不同于批量插入，它sql执行成功返回的是1
            restResult.setStatus(Constants.StatusCode.FAIL_CODE);
            restResult.setErrorMsg("batch delete failed");
        } else {
            restResult.setStatus(Constants.StatusCode.SUCCESS_CODE);
        }
        return restResult;
    }
}
