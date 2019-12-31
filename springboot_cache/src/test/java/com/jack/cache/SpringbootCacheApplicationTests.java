package com.jack.cache;

import com.jack.cache.mapper.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCacheApplicationTests {

	@Autowired
	ObjectMapper objectMapper;

	@Test
	public void contextLoads() {
		System.out.println(objectMapper.getView(17));
	}

}
