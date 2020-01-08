package com.tw.wh.eshop.domain.product;

import java.math.BigDecimal;

import static com.tw.wh.eshop.util.UuidUtil.newUuid;

public class ProductFactory {
  public static Product create(String name, String description, BigDecimal price) {
    return new Product(newUuid(), name, description, price);
  }
}
