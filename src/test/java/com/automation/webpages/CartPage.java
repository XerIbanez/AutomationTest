package com.automation.webpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;

    @FindBy(how=How.ID,using = "cart_title")
    private WebElement cartTitle;

    @FindBy(linkText = "Proceed to checkout")
    private WebElement checkOutButton;

    public CartPage(WebDriver driver){
        this.driver=driver;

        //Initialize Elements
        PageFactory.initElements(driver,this);
    }

    public boolean isCartOpened(){
        return cartTitle.getText().toString().contains("SHOPPING-CART SUMMARY");
    }

    public void clickOnCheckoutButton(){
        checkOutButton.click();
    }





}
