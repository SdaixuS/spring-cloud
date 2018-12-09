package com.daixu.springCloud.tom;

import com.daixu.springCloud.tom.service.JerryService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
@RefreshScope
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients
public class TomService {

  @Autowired
  JerryService jerryService;

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

  @GetMapping(value = "/talkToJerry",  produces = "application/json")
  public String talkToJerry() {
    String res = jerryService.sayHi();
    return "tom: hi, jerry\njerry: " + res;
  }
}
