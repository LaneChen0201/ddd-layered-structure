package com.tw.wh.eshop.domain.product;

import com.tw.wh.eshop.common.ddd.AggregateRoot;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class Product implements AggregateRoot{
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private Instant createdAt;

    public Product() {
    }

    public Product(String id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdAt = Instant.now();
    }

}
