package com.spring.demo.test;

import com.spring.demo.entity.Phone;
import com.spring.demo.mapper.UserInfoMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

/**
 * @Description: TODO
 * @Author: Super
 * @CreateDate: 2020/8/6 16:26
 * @Version: 1.0
 */
@SpringBootTest
public class PhoneTest {
	@Autowired
	private UserInfoMapper userInfoMapper;

	@Test
	public void test() {
		Phone phone = new Phone();
		phone.setBrand("努比亚");
		int num = userInfoMapper.insertPhone(phone);
		System.out.println("id = " + phone.getId());
		Assertions.assertEquals(1, num);
	}
}
