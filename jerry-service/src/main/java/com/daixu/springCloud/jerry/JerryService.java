package com.daixu.springCloud.jerry;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
@RefreshScope
public class JerryService {

  @Value("${sayYeah}")
  public String sayYeah;

  public static void main(String[] args) {
    SpringApplication.run(JerryService.class, args);
  }

  @GetMapping(value = "yeah", produces = "application/json")
  public String sayYeah() {
    return sayYeah;
  }
}
