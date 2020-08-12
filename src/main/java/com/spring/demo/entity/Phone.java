package com.spring.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: TODO
 * @Author: Super
 * @CreateDate: 2020/7/28 17:36
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
public class Phone {
	private int id;
	private String brand; // 品牌
	private String model; // 型号
	private int salary; // 价格
}
