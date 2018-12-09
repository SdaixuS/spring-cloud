package com.daixu.springCloud.tom.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("jerryService")
public interface JerryService {
  @RequestMapping(method = RequestMethod.GET, value = "/yeah")
  String sayHi();
}
