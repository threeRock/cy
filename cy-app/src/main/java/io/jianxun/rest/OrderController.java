package io.jianxun.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import io.jianxun.rest.vo.OrderVo;
import io.jianxun.rest.vo.PageReturnVo;
import io.jianxun.rest.vo.ReturnVo;

@RestController
public class OrderController extends BaseRestController {

	@RequestMapping(value = "order", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
	public ReturnVo<OrderVo> create(@RequestBody Order order) {
		return ReturnVo.ok(OrderVo.toVo(orderService.save(order)), "订单保存成功");
	}

	// 客户查询
	@RequestMapping("orders")
	PageReturnVo<List<OrderVo>> orders(@QuerydslPredicate(root = Order.class) Predicate predicate,
			@PageableDefault(value = 20, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable) {
		Page<Order> orders = orderService.findActivePage(predicate, pageable);
		return (PageReturnVo<List<OrderVo>>) PageReturnVo.builder(orders, OrderVo.toVo(orders.getContent()));

	}

	@Autowired
	private OrderService orderService;

}
