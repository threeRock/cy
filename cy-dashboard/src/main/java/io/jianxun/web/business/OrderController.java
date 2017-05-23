package io.jianxun.web.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.querydsl.core.types.Predicate;

import io.jianxun.extend.domain.business.Order;
import io.jianxun.extend.domain.business.Role;
import io.jianxun.extend.service.business.OrderService;
import io.jianxun.web.utils.Utils;

@Controller
@RequestMapping("order")
public class OrderController {

	/**
	 * 分页列表 支持 查询 分页 及 排序
	 */
	@RequestMapping(value = { "/", "/page" })
	@PreAuthorize("hasAuthority('ORDERLIST')")
	String page(Model model, @QuerydslPredicate(root = Role.class) Predicate predicate,
			@PageableDefault(value = 20, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable,
			@RequestParam MultiValueMap<String, String> parameters) {
		Page<Order> page = orderService.findActivePage(predicate, pageable);
		util.addPageInfo(model, parameters, page);
		util.addSearchInfo(model, parameters);
		return templatePrefix() + Utils.PAGE_TEMPLATE_SUFFIX;
	}
	
	private String templatePrefix() {
		return "order/";
	}

	@Autowired
	private OrderService orderService;

	@Autowired
	private Utils util;

}
