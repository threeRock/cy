package io.jianxun.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jianxun.rest.vo.ReturnVo;
import io.jianxun.service.AppInfo;

@RestController
public class AppInfoController {

	private static Logger logger = LoggerFactory.getLogger(AppInfoController.class);

	private AppInfoController(AppInfo appInfo) {
		this.appInfo = appInfo;
	}

	private AppInfo appInfo;

	// 获取app相关信息
	@PostMapping(value = "appinfo")
	public ReturnVo<AppInfo> createAuthenticationToken() {
		logger.info("获取app版本等相关信息");
		return ReturnVo.ok(appInfo);
	}

}
