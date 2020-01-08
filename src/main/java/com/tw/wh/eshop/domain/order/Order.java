package com.tw.wh.eshop.domain.order;

import com.tw.wh.eshop.domain.order.exception.OrderCannotBeModifiedException;
import com.tw.wh.eshop.domain.order.exception.PaidPriceNotSameWithOrderPriceException;
import com.tw.wh.eshop.domain.order.exception.ProductNotInOrderException;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.tw.wh.eshop.domain.order.OrderStatus.CREATED;
import static com.tw.wh.eshop.domain.order.OrderStatus.PAID;
import static java.math.BigDecimal.ZERO;
import static java.time.Instant.now;

public class Order {
    private String id;
    private List<OrderItem> items = newArrayList();
    private BigDecimal totalPrice;
    private OrderStatus status;
    private Instant createdAt;

    private Order() {
    }

    private Order(String id, List<OrderItem> items) {
        this.id = id;
        this.items.addAll(items);
        this.totalPrice = calculateTotalPrice();
        this.status = CREATED;
        this.createdAt = now();
    }

    public static Order create(String id, List<OrderItem> items) {
        return new Order(id, items);
    }

    private BigDecimal calculateTotalPrice() {
        return items.stream()
                .map(OrderItem::totalPrice)
                .reduce(ZERO, BigDecimal::add);

    }

    public void updateProductCount(String productId, int count) {
        if (this.status == PAID) {
            throw new OrderCannotBeModifiedException(this.id);
        }
        OrderItem orderItem = items.stream()
                .filter(item -> item.getProductId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new ProductNotInOrderException(productId, id));

        orderItem.updateCount(count);

        this.totalPrice = calculateTotalPrice();
    }

    public void pay(BigDecimal paidPrice) {
        if (!this.totalPrice.equals(paidPrice)) {
            throw new PaidPriceNotSameWithOrderPriceException(id);
        }
        this.status = PAID;
    }

    public String getId() {
        return id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}
