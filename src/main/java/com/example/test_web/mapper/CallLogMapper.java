package com.example.test_web.mapper;

import java.util.HashMap;
import java.util.List;

import com.example.test_web.model.CallLog;
import org.springframework.stereotype.Repository;

@Repository
public interface CallLogMapper {
  List<CallLog> getCallLogList(HashMap<String, String> paramsMap);
}
