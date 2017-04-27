package io.jianxun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import io.jianxun.service.AppInfo;

@SpringBootApplication
@EnableConfigurationProperties(AppInfo.class)
public class CyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CyAppApplication.class, args);
	}
}
