package com.homework.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AddProject {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        //设置全局隐式等待
        chromeDriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        chromeDriver.manage().window().maximize();
        // 打开前程贷管理后台，并登陆
        chromeDriver.get("http://8.129.91.152:8765//Admin/Index/login.html");
        chromeDriver.findElement(By.xpath("//input[@name=\"admin_name\"]")).sendKeys("lemon7");
        chromeDriver.findElement(By.xpath("//input[@name=\"admin_pwd\"]")).sendKeys("lemonbest");
        chromeDriver.findElement(By.xpath("//input[@name=\"code\"]")).sendKeys("hapi");
        chromeDriver.findElement(By.xpath("//button[text()=\"登陆后台\"]")).click();
        // 点击借款管理
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//span[text()=\"借款管理\"]")).click();
        // 切换iframe
        chromeDriver.switchTo().frame("mainFrame");
        // 点击加标
        chromeDriver.findElement(By.xpath("//span[text()=\"加标\"]")).click();
        // 填写借款信息
        chromeDriver.findElement(By.xpath("//input[contains(@placeholder,\"输入手机号码\")]")).sendKeys("13323234444");
        Thread.sleep(1000);
        chromeDriver.findElement(By.xpath("//input[contains(@placeholder,\"输入手机号码\")]")).sendKeys(Keys.ARROW_DOWN);
        chromeDriver.findElement(By.xpath("//input[contains(@placeholder,\"输入手机号码\")]")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//td[text()=\"贷款标题:\"]//following-sibling::td/input")).sendKeys("Crystal_test");
        chromeDriver.findElement(By.xpath("//td[text()=\"年利率利息:\"]//following-sibling::td/input")).sendKeys("4");
        chromeDriver.findElement(By.xpath("//td[text()=\"借款期限:\"]//following-sibling::td/input")).sendKeys("6");
        chromeDriver.findElement(By.xpath("//td[text()=\"借款额度:\"]//following-sibling::td/input")).sendKeys("10000");
        chromeDriver.findElement(By.xpath("//td[text()=\"竞标期限:\"]//following-sibling::td/input")).sendKeys("30");
        // 填写风控评测
        chromeDriver.findElement(By.xpath("//span[text()=\"风控评测\"]")).click();
        chromeDriver.findElement(By.xpath("//td[text()=\"评估价值:\"]//following-sibling::td/input")).sendKeys("10000");
        // 填写项目录入
        chromeDriver.findElement(By.xpath("//span[text()=\"项目录入\"]")).click();
        chromeDriver.findElement(By.xpath("//td[text()=\"籍贯:\"]//following-sibling::td/input")).sendKeys("江苏");
        chromeDriver.findElement(By.xpath("//td[text()=\"职业:\"]//following-sibling::td/input")).sendKeys("测试工程师");
        chromeDriver.findElement(By.xpath("//td[text()=\"年龄:\"]//following-sibling::td/input")).sendKeys("20");
        // 点击提交
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//span[text()=\"提交\"]")).click();
        // 审核项目
        for(int i=0;i<3;i++){
            Thread.sleep(2000);
            chromeDriver.findElement(By.xpath("//div[text()=\"Crystal_test\"]")).click();
            chromeDriver.findElement(By.xpath("//span[text()=\"审核\"]")).click();
            chromeDriver.findElement(By.xpath("//span[text()=\"审核通过\"]")).click();
        }
    }
}
