package com.daixu.springCloud.mindMap.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  public static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

  @RequestMapping("hello")
  public String hello(){
    LOGGER.info("Hello method is called");
    return "hello, this is mindMap!";
  }
}
