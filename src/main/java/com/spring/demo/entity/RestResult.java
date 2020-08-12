package com.spring.demo.entity;

import lombok.Data;

/**
 * @Description: TODO
 * @Author: Super
 * @CreateDate: 2020/6/24 22:17
 * @Version: 1.0
 */
@Data
public class RestResult {
    private Object Data;
    private int status;
    private String errorMsg;
}
