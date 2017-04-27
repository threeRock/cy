package io.jianxun.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

import io.jianxun.rest.vo.HomeInfoVo;
import io.jianxun.rest.vo.ReturnVo;

@RestController
public class HomeController {

	/**
	 * 主界面数据接口
	 * 
	 * commonKey 关键字
	 * 
	 * @return
	 */
	@PostMapping("homeinfo")
	public ReturnVo<HomeInfoVo> getHomeInfo() {
		logger.info("获取主界面信息");
		List<String> mockData = Lists.newArrayList("安脑丸", "胰岛素", "板蓝根", "退烧药");
		return ReturnVo.ok(new HomeInfoVo(mockData));
	}

	private static Logger logger = LoggerFactory.getLogger(HomeController.class);

}
