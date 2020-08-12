package com.spring.demo.test;

import com.spring.demo.entity.User;
import com.spring.demo.utils.Constants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class RedisTest {
	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	void stringTest() {
		ValueOperations valueOperations = redisTemplate.opsForValue();
		if (!redisTemplate.hasKey("name")) {
			valueOperations.set("name", "Jordan");
		}
		Assertions.assertEquals("Jordan", valueOperations.get("name"));
	}

	@Test
	void hashTest() {
		HashOperations hashOperations = redisTemplate.opsForHash();
		if (!hashOperations.hasKey("MySet", "name")) {
			hashOperations.put("MySet", "name", "ken");
		}
		Assertions.assertEquals("ken", hashOperations.get("MySet", "name"));
		Map<String, String> map = new HashMap<>(Constants.NumberConstants.INT_THREE);
		map.put("age", "12");
		map.put("job", "java开发工程师");
		map.put("salary", "12000");
		hashOperations.putAll("MySet", map);
		System.out.println("All keys is " + hashOperations.keys("MySet") + "\rAll values is " + hashOperations.values("MySet"));
		hashOperations.delete("MySet", "job");
		System.out.println("All keys is " + hashOperations.keys("MySet") + "\rAll values is " + hashOperations.values("MySet") );

	}

	@Test
	void hashTest2() {
		HashOperations hashOperations = redisTemplate.opsForHash();
		User user = new User(1, "Tom", "666", 32, "男", "17584562011");
		if (!hashOperations.hasKey("MySet", "user")) {
			hashOperations.put("MySet", "user", user);
			System.out.println("insert one data in MySet, user is " + user.toString());
		}
	}

}