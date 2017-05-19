package io.jianxun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import io.jianxun.config.AuditorAwareImpl;
import io.jianxun.extend.domain.business.User;

/*
长药后台管理
*/
@SpringBootApplication
@EnableJpaAuditing
@EnableSpringDataWebSupport
public class CyDashboardApplication {

	@Bean
	public AuditorAware<User> auditorProvider() {
		return new AuditorAwareImpl();
	}

	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}

	public static void main(String[] args) {
		SpringApplication.run(CyDashboardApplication.class, args);
	}
}
