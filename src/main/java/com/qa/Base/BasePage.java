package com.qa.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BasePage {
    public WebDriver driver;
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
    private static String PAGE_URL="https://www.automationpractice.com";

    public WebDriver initialize_driver() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromeWebDriver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(PAGE_URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return getDriver();
    }
    public static synchronized WebDriver getDriver() {
        return tdriver.get();
    }


}
