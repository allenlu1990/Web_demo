package com.example.test_web.controller;

import java.util.HashMap;
import java.util.List;

import com.example.test_web.model.CallLog;
import com.example.test_web.service.CallLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloWorldController {
  @Autowired
  CallLogService callLogService;

  @RequestMapping("/hello_world")
  public List<CallLog> helloWorld() {

    HashMap<String, String> hashMap = new HashMap<>();
    hashMap.put("telephone", "15542823911");
    hashMap.put("year", "2019");
    hashMap.put("month", "7");
    hashMap.put("day", "08");

    List<CallLog> list = callLogService.getCallLogList(hashMap);

    return list;
  }
}
