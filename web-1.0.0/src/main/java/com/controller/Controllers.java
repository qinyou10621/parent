package com.controller;

import com.pojo.Classes;
import com.service.TestService;
import com.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/check")
public class Controllers {
    private Logger LOGGER = LoggerFactory.getLogger(Controllers.class);

    @Autowired
    private TestService testService;


    @RequestMapping("/login")
    public String website() {
        return "index";
    }

    @RequestMapping("/checkInformation")
    @ResponseBody
    public JsonResult<List<Classes>> checkInformation(@RequestParam String username) {
        LOGGER.info("接收到的参数班级名称 username={}", username);
        List<Classes> list = testService.findInformation(username);
        if (list != null) {

        }
        return new JsonResult<List<Classes>>(list);
    }
}
