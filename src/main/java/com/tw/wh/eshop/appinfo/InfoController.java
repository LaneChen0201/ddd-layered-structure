package com.tw.wh.eshop.appinfo;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.Arrays;

@RestController
@RequestMapping(value = "/info")
public class InfoController {

  private Environment environment;

  public InfoController(Environment environment) {
    this.environment = environment;
  }

  @GetMapping
  @ResponseBody
  public InfoPTO about() {
    String activeProfiles = Arrays.toString(environment.getActiveProfiles());
    return new InfoPTO(
        environment.getProperty("spring.application.name"),
        ZonedDateTime.now().toString(),
        activeProfiles);
  }
}
