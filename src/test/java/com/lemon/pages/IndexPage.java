package com.lemon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexPage {
    By quitBy = By.linkText("退出");
    // 我的账户
    // 抢投标


    public boolean isQuitVisible(WebDriver driver){
        WebElement webElement1 = driver.findElement(quitBy);
        boolean isQuitDisplay = webElement1.isDisplayed();
        return isQuitDisplay;
    }
}
