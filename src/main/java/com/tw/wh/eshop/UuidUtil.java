package com.tw.wh.eshop;

import java.util.UUID;

public class UuidUtil {
  public static String newUuid() {
    return UUID.randomUUID().toString().replace("-", "");
  }
}
