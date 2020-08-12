package com.spring.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author: Super
 * @CreateDate: 2020/6/24 17:36
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@ApiModel("用户信息实体") // 接口文档Model注解
public class User implements Serializable {
	private static final long serialVersionUID = 2687783510576030075L;

	@ApiModelProperty(name = "id", value = "用户id")
	private Integer id;
	@ApiModelProperty(value = "用户名") // 接口文档Model属性注解
    private String userName;
	@ApiModelProperty(value = "用户密码")
    private String passWord;
	@ApiModelProperty(value = "用户年龄")
    private Integer age;
	@ApiModelProperty(value = "用户性别")
    private String sex;
	@ApiModelProperty(value = "用户手机号")
    private String phone;
}
