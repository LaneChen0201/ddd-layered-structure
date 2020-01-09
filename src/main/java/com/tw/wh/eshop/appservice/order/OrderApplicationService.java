package com.tw.wh.eshop.appservice.order;

import com.tw.wh.eshop.common.ddd.ApplicationService;
import com.tw.wh.eshop.domain.order.Order;
import com.tw.wh.eshop.domain.order.OrderFactory;
import com.tw.wh.eshop.domain.order.OrderItem;
import com.tw.wh.eshop.domain.order.OrderRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderApplicationService implements ApplicationService {
  private final OrderRepository repository;
  private final OrderFactory factory;

  public OrderApplicationService(OrderRepository repository, OrderFactory factory) {
    this.repository = repository;
    this.factory = factory;
  }

  @Transactional
  public String createOrder(CreateOrderCommand command) {
    List<OrderItem> items =
        command.getItems().stream()
            .map(
                item -> OrderItem.create(item.getProductId(), item.getCount(), item.getItemPrice()))
            .collect(Collectors.toList());

    Order order = factory.create(items);
    repository.save(order);
    return order.getId();
  }

}
