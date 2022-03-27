package com.automation.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"create-account_form\"]/div/p")
    private WebElement createAccountForm;

    @FindBy(how=How.ID,using = "email_create")
    private WebElement createAccountField;

    @FindBy(how=How.ID,using = "SubmitCreate")
    private WebElement createAccountButton;

    //Constructor
    public SignInPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public boolean isSignInPageOpened(){
        return createAccountForm.getText().toString().contains("Please enter your email address to create an account.");
    }

    public void enterEmailToCreateAccount(){
        createAccountField.sendKeys("user_"+System.currentTimeMillis()+"@test.com");
    }

    public void clickOnCreateAccountButton(){
        createAccountButton.click();
    }


}
