package com.lemon.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {
    /**
     * 统一浏览器封装
     * @param browserName 指定打开浏览器名
     */
    public WebDriver openBrowser(String browserName){
        if("chrome".equalsIgnoreCase(browserName)){
            //执行打开chrome的代码
            //System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
            return new ChromeDriver();
        }else if("firefox".equalsIgnoreCase(browserName)){
            //执行打开firefox的代码
            System.setProperty("webdriver.gecko.driver","src\\test\\resources\\geckodriver.exe");
            return new FirefoxDriver();
        }else if("ie".equalsIgnoreCase(browserName)){
            //执行打开ie的代码
            //取消IE安全设置（忽略IE的Protected Mode的设置）
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            //忽略掉浏览器缩放设置问题
            capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            //表示让我们脚本使用对应的驱动程序iedriver.exe
            System.setProperty("webdriver.ie.driver","src\\test\\resources\\IEDriverServer.exe");
            return new InternetExplorerDriver(capabilities);
        }else {
            System.out.println("浏览器不支持，请确认你的浏览器名是否正确");
            return null;
        }
    }
}
