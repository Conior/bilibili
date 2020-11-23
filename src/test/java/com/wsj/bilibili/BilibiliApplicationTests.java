package com.wsj.bilibili;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class BilibiliApplicationTests {
	@Autowired
	DataSource dataSource;

	@Test
	void contextLoads() {
		System.out.println(dataSource.getClass());
	}

}
