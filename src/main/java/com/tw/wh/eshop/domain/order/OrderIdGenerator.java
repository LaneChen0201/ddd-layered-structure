package com.tw.wh.eshop.domain.order;

import com.tw.wh.eshop.util.UuidUtil;
import com.tw.wh.eshop.common.ddd.DomainService;
import org.springframework.stereotype.Component;

@Component
public class OrderIdGenerator implements DomainService {

  public String generate() {
    return UuidUtil.newUuid();
  }
}
