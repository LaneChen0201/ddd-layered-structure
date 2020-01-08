package com.tw.wh.eshop.domain.order.exception;

public class ProductNotInOrderException extends RuntimeException {
  public ProductNotInOrderException(String productId, String id) {}
}
