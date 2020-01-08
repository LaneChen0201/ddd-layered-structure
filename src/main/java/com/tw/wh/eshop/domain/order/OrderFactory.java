package com.tw.wh.eshop.domain.order;

import com.tw.wh.eshop.common.ddd.DomainService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderFactory implements DomainService {
  private final OrderIdGenerator idGenerator;

  public OrderFactory(OrderIdGenerator idGenerator) {
    this.idGenerator = idGenerator;
  }

  public Order create(List<OrderItem> items) {
    String orderId = idGenerator.generate();
    return Order.create(orderId, items);
  }
}
