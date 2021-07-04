package com.homework.day05;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppAuto {
    public static void main(String[] args) throws MalformedURLException {
        // 实例化配置对象
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        // 1、指定一台设备
        desiredCapabilities.setCapability("deviceName","127.0.0.1:62001");
        // 2、指定测试平台
        desiredCapabilities.setCapability("platformName","Andriod");
        // 3、指定测试APP
        desiredCapabilities.setCapability("appPackage","com.lemon.lemonban");
        // 4、APP启动配置
        desiredCapabilities.setCapability("appActivity","com.lemon.lemonban.activity.WelcomeActivity");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        // 把配置发给Appium服务器（Driver实例化）
        AndroidDriver androidDriver = new AndroidDriver(url,desiredCapabilities);
    }
}
