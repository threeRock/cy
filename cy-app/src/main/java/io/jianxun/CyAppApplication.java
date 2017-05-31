package io.jianxun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.jianxun.config.AuditorAwareImpl;
import io.jianxun.extend.domain.business.User;
import io.jianxun.extend.service.business.StorageProperties;
import io.jianxun.service.AppInfo;

@SpringBootApplication
@EnableConfigurationProperties({AppInfo.class,StorageProperties.class})
@EnableJpaAuditing
public class CyAppApplication {

	@Bean
	public AuditorAware<User> auditorProvider() {
		return new AuditorAwareImpl();
	}

	public static void main(String[] args) {
		SpringApplication.run(CyAppApplication.class, args);
	}
}
