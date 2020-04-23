package com.example.test_web.service;

import java.util.HashMap;
import java.util.List;

import com.example.test_web.mapper.CallLogMapper;
import com.example.test_web.model.CallLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CallLogService {
  @Autowired
  CallLogMapper callLogMapper;
  public List<CallLog> getCallLogList(HashMap<String, String> paramsMap){
    return callLogMapper.getCallLogList(paramsMap);
  }
}
