package com.daixu.springCloud.tom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringCloudApplication
@RestController
@RequestMapping("/")
@RefreshScope
public class TomService {

  @Value("${sayhi}")
  public String sayHi;

  public static void main(String[] args) {
    SpringApplication.run(TomService.class, args);
  }

  @GetMapping(value = "/hi", produces = "application/json")
  public String sayHi() {
    return sayHi;
  }
}