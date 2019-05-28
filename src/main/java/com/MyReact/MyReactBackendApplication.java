package com.MyReact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.MyReact.dao") // JPA扫描该包路径下的Repositorie
@EntityScan("com.MyReact.domain") // 扫描Entity实体类
public class MyReactBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyReactBackendApplication.class, args);
	}
}
