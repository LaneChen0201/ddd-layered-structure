package com.tw.wh.eshop.appservice.product;

import java.math.BigDecimal;

public class ProductPTO {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;

    public ProductPTO(String id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
