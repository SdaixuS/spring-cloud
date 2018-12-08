package com.daixu.springCloud.tom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
@RefreshScope
@EnableDiscoveryClient
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
