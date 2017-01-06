package com.aop;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/1/6 0006.
 */
@Component
public class AopTest {
    public void aopBefore() {
        System.out.println("AopAspectBefore");
    }
}
