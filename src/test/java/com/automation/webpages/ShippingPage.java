package com.automation.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"columns\"]/div[1]/span[2]")
    private WebElement shippingPageTitle;

    @FindBy(how=How.ID,using = "uniform-cgv")
    private WebElement termsOfService;

    @FindBy(xpath = "//*[@id=\"form\"]/p/button/span")
    private WebElement proceedToCheckoutButton;


    public ShippingPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isShippingPageOpened(){
        return shippingPageTitle.getText().toString().contains("Shipping");
    }

    public void clickOnTermsOfService(){
        termsOfService.click();
    }

    public void clickOnProceedButton(){
        proceedToCheckoutButton.click();
    }
}
