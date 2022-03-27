package com.automation.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class PaymentPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"columns\"]/div[1]/span[2]")
    private WebElement paymentPageTitle;

    @FindBy(how=How.CLASS_NAME,using = "bankwire")
    private WebElement payByBankWireButton;

    public PaymentPage(WebDriver driver){
        this.driver=driver;
        //Initialize Elements
        PageFactory.initElements(driver,this);
    }

    public boolean isPaymentPageOpened(){
        return paymentPageTitle.getText().toString().contains("Your payment method");
    }

    public void clickOnPayByBankWire(){
        payByBankWireButton.click();
    }

}
