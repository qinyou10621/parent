package com.aop;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/1/6 0006.
 */
@Component
public class AopTest {
    public void aopBefore() {
        System.out.println("aop:before");
    }

    public void aopException() {
        System.out.println("aop:after-throwing");
        System.out.print("11111");

    }
}
