package io.jianxun.extend.service.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.jianxun.extend.domain.business.Order;
import io.jianxun.extend.domain.business.OrderStatus;
import io.jianxun.extend.service.AbstractBaseService;
import io.jianxun.extend.service.BusinessException;

@Service
public class OrderService extends AbstractBaseService<Order> {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Order delete(Order order) {
		if (canModify(order))
			return super.delete(order);
		throw new BusinessException(String.format("状态为%s的订单不能删除", order.getStatus()));
	}

	public boolean canModify(Order order) {
		return OrderStatus.CREATE.equals(order.getStatus());
	}

	public Order commit(Order order) {
		if (canModify(order))
			return super.save(order);
		throw new BusinessException(String.format("状态为%s的订单不能提交", order.getStatus()));
	}

}
