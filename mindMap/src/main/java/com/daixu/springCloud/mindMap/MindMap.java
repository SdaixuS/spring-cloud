package com.daixu.springCloud.mindMap;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MindMap {

  public static void main(String[] args) {
    SpringApplication.run(MindMap.class, args);
  }
}
