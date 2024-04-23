package com.gamifyverse.gamifyapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("tst")
class GamifyApiApplicationTests {

	@Value("${spring.environment-type}")
	private String environmentType;
	
	@Test
	void contextLoads() {
		assertEquals("test", environmentType);
	}

}
