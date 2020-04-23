package com.example.test_web.controller;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;

import com.example.test_web.model.CallLog;
import com.example.test_web.model.QueryInfo;
import com.example.test_web.service.CallLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/callLog")
public class CallLogController {
  @Autowired
  CallLogService callLogService;

  //  @RequestMapping("/")
  //  public String defaultController(){
  //    return "index";
  //  }

  @RequestMapping("/queryCallLogList")
  public String queryCallLog(Model model, QueryInfo queryInfo) {

    HashMap<String, String> hashMap = new HashMap<>();
    hashMap.put("telephone", queryInfo.getTelephone());
    hashMap.put("year", queryInfo.getYear());
    hashMap.put("month", queryInfo.getMonth());
    hashMap.put("day", queryInfo.getDay());

    List<CallLog> list = callLogService.getCallLogList(hashMap);

    StringBuilder dateSB = new StringBuilder();
    StringBuilder callSumSB = new StringBuilder();
    StringBuilder callDurationSumSB = new StringBuilder();

    for (int i = 0; i < list.size(); i++) {
      CallLog callLog = list.get(i);
      //1月, 2月, ....12月,
      dateSB.append(callLog.getMonth() + "月,");
      callSumSB.append(callLog.getCall_sum() + ",");
      callDurationSumSB.append(callLog.getCall_duration_sum() + ",");
    }

    dateSB.deleteCharAt(dateSB.length() - 1);
    callSumSB.deleteCharAt(callSumSB.length() - 1);
    callDurationSumSB.deleteCharAt(callDurationSumSB.length() - 1);

    //通过model返回数据
    model.addAttribute("telephone", list.get(0).getTelephone());
    model.addAttribute("name", list.get(0).getName());
    model.addAttribute("date", dateSB.toString());
    model.addAttribute("count", callSumSB.toString());
    model.addAttribute("duration", callDurationSumSB.toString());

    return "CallLogListEchart";
  }

}
