package com.tw.wh.eshop.domain.product;

import com.tw.wh.eshop.common.ddd.Repository;

public interface ProductRepository extends Repository {

  void save(Product product);

  Product byId(String id);
}
