package com.lemon.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    Logger logger = Logger.getLogger(BaseTest.class);

    // 输入操作的二次封装
    public void type(WebDriver driver, By by, String desc, String data) {
        driver.findElement(by).sendKeys(data);
        logger.info("往元素【" + desc + "】输入了数据【" + data + "】");
    }

    // 获取元素文本值的二次封装
    public String getText(WebDriver driver, By by, String desc) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        logger.info("获取元素【" + desc + "】文本【" + webElement.getText() + "】");
        return webElement.getText();
    }

    // 获取元素属性的二次封装
    public String getAttribute(WebDriver driver, By by, String attributename, String desc) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        logger.info("获取元素【" + desc + "】属性【" + webElement.getAttribute(attributename) + "】");
        return webElement.getAttribute(attributename);
    }
}
