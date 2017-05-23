package io.jianxun.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.types.Predicate;

import io.jianxun.extend.domain.business.Order;
import io.jianxun.extend.service.business.OrderService;
import io.jianxun.rest.vo.PageReturnVo;
import io.jianxun.rest.vo.ReturnVo;

@RestController
public class OrderController extends BaseRestController {

	@RequestMapping(value = "order", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
	public ReturnVo<Order> create(@RequestBody Order order) {
		return ReturnVo.ok(orderService.save(order), "订单保存成功");
	}

	// 客户查询
	@RequestMapping("orders")
	PageReturnVo<Order> orders(@QuerydslPredicate(root = Order.class) Predicate predicate,
			@PageableDefault(value = 20, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable) {
		return PageReturnVo.builder(orderService.findActivePage(predicate, pageable));

	}

	@Autowired
	private OrderService orderService;

}
