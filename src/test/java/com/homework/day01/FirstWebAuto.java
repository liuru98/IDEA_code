package com.homework.day01;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirstWebAuto {
    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
//        ChromeDriver chromeDriver = new ChromeDriver();
//        chromeDriver.get("http://www.baidu.com/");
//        openFirefox();
        openIE();
    }

    public static void openFirefox(){
        System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver.exe");
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("http://www.baidu.com/");
    }

    public static void openIE(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
        capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL,"http://www.baidu.com/");
        System.setProperty("webdriver.ie.driver","src/test/resources/IEDriverServer.exe");
        InternetExplorerDriver internetExplorerDriver = new InternetExplorerDriver();

    }
}
