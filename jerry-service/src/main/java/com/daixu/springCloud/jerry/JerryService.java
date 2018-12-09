package com.daixu.springCloud.jerry;

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
public class JerryService {

  @Value("${sayYeah}")
  public String sayYeah;

  public static void main(String[] args) {
    SpringApplication.run(JerryService.class, args);
  }

  @GetMapping(value = "yeah", produces = "application/json")
  @HystrixCommand(groupKey = "jerry",fallbackMethod = "jerryIsBusy")
  public String sayYeah() {
    return sayYeah;
  }

  public String jerryIsBusy() {
    return "Jerry is busy ";
  }

  @GetMapping(value = "eatShit", produces = "application/json")
  @HystrixCommand(groupKey = "jerry",fallbackMethod = "jerryIsBusy")
  public String eatShit() {
    throw new RuntimeException("will never do that");
  }
}
