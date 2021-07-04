package com.homework.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InvestBit {
    public static void main(String[] args) throws InterruptedException {
        AddBit.addBit();
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        //设置全局隐式等待
        chromeDriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        chromeDriver.manage().window().maximize();
        // 打开前程贷管理前台，并登陆
        chromeDriver.get("http://8.129.91.152:8765/");
        chromeDriver.findElement(By.xpath("//a[text()=\"登录\"]")).click();
        chromeDriver.findElement(By.xpath("//input[@placeholder=\"手机号\"]")).sendKeys("13323234545");
        chromeDriver.findElement(By.xpath("//input[@placeholder=\"密码\"]")).sendKeys("lemon123456");
        chromeDriver.findElement(By.xpath("//button[text()=\"登录\"]")).click();
        Thread.sleep(2000);
        // 找到项目，点击抢投标
        chromeDriver.findElement(By.xpath("//span[contains(text(),\"Crystal_test2\")]/parent::div/parent::a" +
                "/following-sibling::div//a[text()=\"抢投标\"]")).click();
        // 输入投标金额，点击投标
        chromeDriver.findElement(By.xpath("//input[contains(@class,\"invest\")]")).sendKeys("1000");
        chromeDriver.findElement(By.xpath("//button[text()=\"投标\"]")).click();
    }
}
