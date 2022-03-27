package com.automation.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.core.annotation.Order;

public class OrderSummaryPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"columns\"]/div[1]/span[2]")
    private WebElement orderPageTitle;

    @FindBy(xpath = "//*[@id=\"center_column\"]/form/div/h3")
    private WebElement paymentTypeTitle;

    @FindBy(xpath = "//*[@id=\"center_column\"]/form/div/p[1]/strong")
    private WebElement chosenPaymentTypeDescription;

    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button/span/text()")
    private WebElement confirmOrderButton;

    public OrderSummaryPage(WebDriver driver){
        this.driver=driver;
        //Initialize Elements
        PageFactory.initElements(driver,this);
    }

    public boolean isOrderSummaryPageOpened(){
        return orderPageTitle.getText().toString().contains("Bank-wire payment.");
    }
}
