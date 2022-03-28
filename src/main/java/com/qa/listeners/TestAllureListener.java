package com.qa.listeners;

import com.qa.Base.BasePage;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestAllureListener implements ITestListener{
    private static String getTestMethodName(ITestResult iTestResult){
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    /*public static synchronized WebDriver getDriver(){
        return tdriver.get();
    }*/
    // Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Attachment(value = "Page Screenshot", type="image/png")
    public byte[] saveScreenshotPNG(WebDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult){
        System.out.println("This is onTestFailure method "+getTestMethodName(iTestResult)+" failed");
        Object testClass=iTestResult.getInstance();
        WebDriver driver = BasePage.getDriver();
        // Allure ScreenShotRobot and SaveTestLog
        if (driver instanceof WebDriver) {
            System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
            saveScreenshotPNG(driver);
        }
        // Save a log on allure.
        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");


    }
}
