package com.tw.wh.eshop.application;

import lombok.Data;

@Data
public class InfoPTO {
  private String applicationName;
  private String deployTime;
  private String environment;

  public InfoPTO(String applicationName, String deployTime, String environment) {
    this.applicationName = applicationName;
    this.deployTime = deployTime;
    this.environment = environment;
  }
}
