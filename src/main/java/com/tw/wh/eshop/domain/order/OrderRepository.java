package com.tw.wh.eshop.domain.order;

import com.tw.wh.eshop.common.ddd.Repository;

public interface OrderRepository extends Repository {
  void save(Order order);

  Order byId(String id);
}
