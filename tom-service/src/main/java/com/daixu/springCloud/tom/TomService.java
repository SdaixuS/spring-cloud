package com.daixu.springCloud.tom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping
@RefreshScope
public class TomService {

  @Value("${sayhi}")
  public String sayHi;

  public static void main(String[] args) {
    SpringApplication.run(TomService.class, args);
  }

  @GetMapping("/hi")
  public String sayHi() {
    return sayHi;
  }
}
