package com.lemon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    // 属性-元素定位信息  元素定位方式+表达式值
    By phoneBy = By.name("phone");
    By passwordBy = By.name("password");
    By loginBy = By.xpath("[text()=\"登录\"]");
    By centerTipsBy = By.className("layui-layer-content");
    By inputTipsBy = By.className("form-error-info");

    public void login(WebDriver driver,String phone,String pwd){
        driver.findElement(phoneBy).sendKeys(phone);
        driver.findElement(passwordBy).sendKeys(pwd);
        driver.findElement(loginBy).click();
    }

    public String getCenterTips(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(centerTipsBy));
        String text = webElement.getText();
        return text;
    }

    public String getInputTips(WebDriver driver){
        WebElement webElement = driver.findElement(inputTipsBy);
        String text = webElement.getText();
        return text;
    }
}


