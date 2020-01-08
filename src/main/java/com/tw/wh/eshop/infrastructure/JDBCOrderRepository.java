package com.tw.wh.eshop.infrastructure;

import com.tw.wh.eshop.domain.order.Order;
import com.tw.wh.eshop.domain.order.OrderRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JDBCOrderRepository implements OrderRepository {

  private final NamedParameterJdbcTemplate jdbcTemplate;

  public JDBCOrderRepository(NamedParameterJdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void save(Order order) {}
}
