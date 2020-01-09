package com.tw.wh.eshop.representation;

import com.tw.wh.eshop.appservice.order.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
  private final OrderApplicationService service;

  public OrderController(OrderApplicationService service) {
    this.service = service;
  }

  @PostMapping
  public String createOrder(@RequestBody @Valid CreateOrderCommand command) {
    return service.createOrder(command);
  }

  @PostMapping("/{id}")
  public void updateProductCount(
      @PathVariable(name = "id") String id, @RequestBody @Valid UpdateProductCountCommand command) {
    // TODO
  }

  @PostMapping("/{id}/payment")
  public void pay(
      @PathVariable(name = "id") String id, @RequestBody @Valid PayOrderCommand command) {
    // TODO: 支付Order
  }

  @GetMapping("/{id}")
  public OrderPTO byId(@PathVariable(name = "id") String id) {
    // TODO
    return null;
  }
}
