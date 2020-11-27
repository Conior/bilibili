package com.wsj.bilibili;

import com.wsj.bilibili.model.UserDTO;
import com.wsj.bilibili.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.Date;

@SpringBootTest
class BilibiliApplicationTests {
	@Autowired
	DataSource dataSource;

	@Autowired
	UserService userService;

//	@Test
	void contextLoads() {

		for (int i = 1 ; i < 20; i++) {
			userService.addUser(new UserDTO(null, "测试账号" + i, "12345678", "970239641@qq.com", "18696415417", 0, new Date(), "广东省_广州市_海珠区", 1, null));
		}
	}

}
