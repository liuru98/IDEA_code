package com.lemon.testcase;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestLogin {
    ChromeDriver driver;
    @BeforeMethod
    public void setup(){
        // 前置
        // 1、打开浏览器
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        // 2、打开登录的URL
        driver.get("http://8.129.91.152:8765/Index/login.html");
        // 窗口最大化
        driver.manage().window().maximize();
        // 全局隐式等待
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }


    @Test(dataProvider = "getLoginRemember")
    public void testLoginRemember(String phone,String pwd,String tips){
        driver.findElement(By.xpath("//input[@placeholder=\"手机号\"]")).sendKeys(phone);
        driver.findElement(By.xpath("//input[@placeholder=\"密码\"]")).sendKeys(pwd);
        driver.findElement(By.name("remember_me"));
        driver.findElement(By.xpath("//button[text()=\"登录\"]")).click();
        driver.findElement(By.xpath("//a[text()=\"退出\"]")).click();
        driver.findElement(By.xpath("//a[text()=\"登录\"]")).click();
        // 断言
        WebElement webElement = driver.findElement(By.xpath("//input[@placeholder=\"手机号\"]"));
        String num = webElement.getAttribute("value");
        Assert.assertEquals(num,tips);
    }

    @DataProvider
    public Object[][] getLoginRemember(){
        Object[][] data ={{"13323234545","lemon123456","13323234545"}};
        return data;
    }

    @Test(dataProvider = "getLoginFailureData1")
    public void testLoginFailure1(String phone,String pwd,String tips){
        driver.findElement(By.xpath("//input[@placeholder=\"手机号\"]")).sendKeys(phone);
        driver.findElement(By.xpath("//input[@placeholder=\"密码\"]")).sendKeys(pwd);
        driver.findElement(By.xpath("//button[text()=\"登录\"]")).click();
        // 断言
        WebElement webElement = driver.findElement(By.className("form-error-info"));
        String text = webElement.getText();
        Assert.assertEquals(text,tips);
    }

    @DataProvider
    public Object[][] getLoginFailureData1(){
        Object[][] data1 ={{"13323234545","","请输入密码"}};
        return data1;
    }


    @Test(dataProvider = "getLoginFailureData2")
    public void testLoginFailure2(String phone,String pwd,String tips) throws InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder=\"手机号\"]")).sendKeys(phone);
        driver.findElement(By.xpath("//input[@placeholder=\"密码\"]")).sendKeys(pwd);
        driver.findElement(By.xpath("//button[text()=\"登录\"]")).click();
        // 断言
        Thread.sleep(2000);
        WebElement webElement = driver.findElement(By.className("layui-layer-content"));
        String text = webElement.getText();
        Assert.assertEquals(text,tips);
    }

    @DataProvider
    public Object[][] getLoginFailureData2(){
        Object[][] data2 = {{"13323234545","123","帐号或密码错误!"}};
        return data2;
    }

    @AfterMethod
    public void teardown(){
        // 后置
        // 6、关闭测试浏览器
        driver.quit();
    }
}
