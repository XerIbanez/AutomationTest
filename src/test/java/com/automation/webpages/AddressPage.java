package com.automation.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"columns\"]/div[1]/span[2]")
    private WebElement addressPageTitle;

    @FindBy(xpath = "//*[text()='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;

    public AddressPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isAddressPageOpened(){
        return addressPageTitle.getText().toString().contains("Addresses");
    }

    public void clickOnProceedButton(){
        proceedToCheckoutButton.click();
    }
}
