package com.controller;

import com.pojo.Classes;
import com.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/12/27 0027.
 */
@Controller
@RequestMapping("/findInformation")
public class Controllers {
    @Autowired
    private TestService testService;

    @RequestMapping("/className")
    @ResponseBody
    public List<Classes> returnData() {
        System.out.print(10 / 0);
        System.out.print("123");
        return testService.findInformation("一班");
    }

    @RequestMapping("/web")
    public String website() {
        System.out.print("456");
        return "index";
    }
}
