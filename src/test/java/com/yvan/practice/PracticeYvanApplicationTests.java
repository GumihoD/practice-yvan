package com.yvan.practice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PracticeYvanApplication.class)
@WebAppConfiguration
public class PracticeYvanApplicationTests {

	@Profile("h2test") // 指定单元测试活动所匹配的数据源
	@Bean(name="datasource") // 要和模拟的数据源名称相对应
	DataSource dataSourceUtils() throws SQLException {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript("/h2test/data.sql")
				.build();
	}
	@Test
	public void contextLoads() {

	}

}
