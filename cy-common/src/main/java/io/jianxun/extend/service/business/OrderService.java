package io.jianxun.extend.service.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.jianxun.extend.domain.business.Order;
import io.jianxun.extend.service.AbstractBaseService;

@Service
public class OrderService extends AbstractBaseService<Order> {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

}
