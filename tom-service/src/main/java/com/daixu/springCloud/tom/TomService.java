package com.daixu.springCloud.tom;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
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
@EnableCircuitBreaker
public class TomService {

  @Value("${sayhi}")
  public String sayHi;

  public static void main(String[] args) {
    SpringApplication.run(TomService.class, args);
  }

  @GetMapping(value = "/hi", produces = "application/json")
  @HystrixCommand(groupKey = "tom",fallbackMethod = "tomIsBusy")
  public String sayHi() {
    return sayHi;
  }

  public String tomIsBusy() {
    return "tom is busy";
  }
}
