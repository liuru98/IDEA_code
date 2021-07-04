package com.lemon.testcase;

import org.apache.log4j.Logger;

public class LogDemo {
    // log4j日志对象
    private static Logger logger = Logger.getLogger(LogDemo.class);

    public static void main(String[] args) {
        logger.info("我的信息是info级别的");
        System.out.println("我的信息是info级别的");
    }
}
