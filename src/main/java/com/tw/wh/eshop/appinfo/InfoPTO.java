package com.tw.wh.eshop.appinfo;

import com.tw.wh.eshop.common.ddd.PresentTransferObject;
import lombok.Data;

@Data
public class InfoPTO implements PresentTransferObject {
  private String applicationName;
  private String deployTime;
  private String environment;

  public InfoPTO(String applicationName, String deployTime, String environment) {
    this.applicationName = applicationName;
    this.deployTime = deployTime;
    this.environment = environment;
  }
}
