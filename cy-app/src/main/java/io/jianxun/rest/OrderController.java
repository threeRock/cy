package io.jianxun.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;

import io.jianxun.config.JwtTokenUtil;
import io.jianxun.extend.domain.business.Order;
import io.jianxun.extend.domain.business.User;
import io.jianxun.extend.service.BusinessException;
import io.jianxun.extend.service.business.OrderPredicates;
import io.jianxun.extend.service.business.OrderService;
import io.jianxun.extend.service.business.UserService;
import io.jianxun.rest.vo.OrderVo;
import io.jianxun.rest.vo.PageReturnVo;
import io.jianxun.rest.vo.ReturnVo;

@RestController
public class OrderController extends BaseRestController {

	// 创建订单
	@RequestMapping(value = "order", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
	public ReturnVo<OrderVo> create(@RequestBody Order order) {
		return ReturnVo.ok(OrderVo.toVo(orderService.save(order)), "订单保存成功");
	}

	// 提交订单
	@RequestMapping(value = "order/commit", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
	public ReturnVo<OrderVo> commit(@RequestBody Order order) {
		order = orderService.findActiveOne(order.getId());
		if (order != null)
			throw new BusinessException("获取订单信息失败,无法提交");
		return ReturnVo.ok(OrderVo.toVo(orderService.commit(order)), "订单提交成功");
	}

	// 所有订单查询
	@RequestMapping("orders")
	PageReturnVo<List<OrderVo>> orders(@QuerydslPredicate(root = Order.class) Predicate predicate,
			@PageableDefault(value = 20, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable,
			HttpServletRequest request) {
		String spmch = request.getParameter("spmch");
		if (StringUtils.isNoneBlank(spmch))
			predicate = ExpressionUtils.and(OrderPredicates.spmchPredicate(spmch), predicate);
		Page<Order> orders = orderService.findActivePage(predicate, pageable);
		return (PageReturnVo<List<OrderVo>>) PageReturnVo.builder(orders, OrderVo.toVo(orders.getContent()));

	}

	// 用户的订单记录
	@RequestMapping("orders/use")
	PageReturnVo<List<OrderVo>> userOrders(HttpServletRequest request,
			@QuerydslPredicate(root = Order.class) Predicate predicate,
			@PageableDefault(value = 20, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable) {
		String token = request.getHeader(tokenHeader);
		String username = jwtTokenUtil.getUsernameFromToken(token);
		if (username == null)
			throw new BusinessException("无法获取用户信息");
		User user = (User) userService.loadUserByUsername(username);
		if (user == null)
			throw new BusinessException("无法获取用户信息");
		predicate = ExpressionUtils.and(OrderPredicates.userPredicate(user), predicate);
		String spmch = request.getParameter("spmch");
		if (StringUtils.isNoneBlank(spmch))
			predicate = ExpressionUtils.and(OrderPredicates.spmchPredicate(spmch), predicate);
		Page<Order> orders = orderService.findActivePage(predicate, pageable);
		return (PageReturnVo<List<OrderVo>>) PageReturnVo.builder(orders, OrderVo.toVo(orders.getContent()));

	}

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Value("${jwt.header}")
	private String tokenHeader;

}
