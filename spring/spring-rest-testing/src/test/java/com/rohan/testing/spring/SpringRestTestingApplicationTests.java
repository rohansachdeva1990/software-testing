package com.rohan.testing.spring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = {"classpath:test-configuration.properties"}) // This has the highest priority => test/app.pro => main/app.pro
class SpringRestTestingApplicationTests {

	@Test
	void contextLoads() {
	}

}
