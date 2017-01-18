package com.controller;

import com.pojo.Classes;
import com.pojo.Student;
import com.service.TestService;
import com.utils.feedback.JsonResult;
import com.utils.imageIdentifying.ValidateCode;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2016/12/27 0027.
 */
@Controller
@RequestMapping("/check")
public class Controllers {
    /**
     * 日志系统
     */
    private Logger LOGGER = LoggerFactory.getLogger(Controllers.class);

    @Autowired
    private TestService testService;


    @RequestMapping("/login")
    public String website() {
//        System.out.println(1 / 0);
        return "login";
    }

    @RequestMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, HttpServletRequest req) {
        /**
         * 将客户端传过来的密码进行sha256加密,存放在数据库;
         */
        String sha256Password = DigestUtils.sha256Hex(password);
        testService.insertUser(username, sha256Password);
        req.getSession().setAttribute("username", username);
        return "login";
    }

    @RequestMapping("/checkInformation")
    @ResponseBody
    public JsonResult<List<Classes>> checkInformation(@RequestParam String username, HttpServletRequest req) {
        LOGGER.info("接收到的参数班级名称 username={}", username);
        List<Classes> list = testService.findInformation(username);
        if (list != null) {
            for (Classes c : list) {
                req.getSession().setAttribute("token", c.getId());
            }
        }
        return new JsonResult<List<Classes>>(list);
    }

    /**
     * 测试spring事务
     */
    @RequestMapping("/transaction")
    public void testTransaction() {
        testService.update(new Student(2, "fff"));
        testService.update(new Student(3, "fff"));
    }

    @RequestMapping("/redis")
    public void redisTest() {
        testService.redisSetTestMS("key101", "qinyou");
        testService.redisGetTestMS("key100");
    }

    /**
     * image图片验证码
     */
    @RequestMapping("/identifyingCode")
    public void identifyingCode(HttpServletRequest req, HttpServletResponse res) {
        ValidateCode vCode = new ValidateCode(70, 25);
        String codePath = "images" + File.separator + "imageCode" + File.separator + UUID.randomUUID().toString() +
                ".png";
        System.out.println(req.getServletContext().getRealPath(""));
        try {
            vCode.write(req.getServletContext().getRealPath("") + File.separator + codePath);
            req.getSession().setAttribute("identifyingCode", vCode.getCode());
            res.getWriter().print(File.separator + codePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
