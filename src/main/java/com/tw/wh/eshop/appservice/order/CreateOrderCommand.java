package com.tw.wh.eshop.appservice.order;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tw.wh.eshop.common.ddd.Command;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class CreateOrderCommand implements Command {
  @Valid
  @NotEmpty(message = "订单项不能为空.")
  private List<OrderItemCommand> items;

  @JsonCreator
  public CreateOrderCommand(@JsonProperty("items") List<OrderItemCommand> items) {
    this.items = items;
  }

  public List<OrderItemCommand> getItems() {
    return items;
  }
}
