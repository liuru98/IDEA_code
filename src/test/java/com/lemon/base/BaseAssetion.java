package com.lemon.base;

import org.apache.log4j.Logger;
import org.testng.Assert;

public class BaseAssetion {
    static Logger logger = Logger.getLogger(BaseAssetion.class);
    // TestNG的assertTrue断言方法二次封装，集成日志
    public static void myAssertTrue(boolean condition){
        try{
            Assert.assertTrue(condition);
        }catch (Exception e){
            logger.error("断言【"+condition+"】失败");
        }
        logger.info("断言【"+condition+"】是否为真");
    }

    // TestNG的assertEquals断言方法二次封装，集成日志
    public static void myAssertEquals(String actual, String expected){
        try{
            Assert.assertEquals(actual, expected);
        }catch (Exception e){
            logger.error("断言【"+actual+"】与期望值【"+expected+"】不同");
        }
        logger.info("断言【"+actual+"】与期望值【"+expected+"】");
    }

    public static void myAssertEquals(int actual, int expected){
        try{
            Assert.assertEquals(actual, expected);
        }catch (Exception e){
            logger.error("断言【"+actual+"】与期望值【"+expected+"】不同");
        }
        logger.info("断言【"+actual+"】与期望值【"+expected+"】");
    }

    public static void myAssertEquals(double actual, double expected){
        try{
            Assert.assertEquals(actual, expected);
        }catch (Exception e){
            logger.error("断言【"+actual+"】与期望值【"+expected+"】不同");
        }
        logger.info("断言【"+actual+"】与期望值【"+expected+"】");
    }
}
