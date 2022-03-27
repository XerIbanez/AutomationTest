package com.automation.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
    private WebDriver driver;

    //Your Personal Information
    @FindBy(how=How.ID,using = "uniform-id_gender1")
    private WebElement titleMr;
    @FindBy(how=How.ID,using = "uniform-id_gender2")
    private WebElement titleMrs;
    @FindBy(how=How.ID,using = "customer_firstname")
    private WebElement customerFirstname;
    @FindBy(how=How.ID,using = "customer_lastname")
    private WebElement customerLastname;
    @FindBy(how=How.ID,using = "passwd")
    private WebElement customerPassword;
    @FindBy(how=How.ID,using = "days")
    private WebElement dayOB;
    @FindBy(how=How.ID,using = "months")
    private WebElement monthOB;
    @FindBy(how=How.ID,using = "years")
    private WebElement yearOB;
    //YOUR ADDRESS
    @FindBy(how=How.ID,using = "firstname")
    private WebElement firstname;
    @FindBy(how=How.ID,using = "lastname")
    private WebElement lastname;
    @FindBy(how=How.ID,using = "company")
    private WebElement company;
    @FindBy(how=How.ID,using = "address1")
    private WebElement address1;
    @FindBy(how=How.ID,using = "address2")
    private WebElement address2;
    @FindBy(how=How.ID,using = "city")
    private WebElement city;
    @FindBy(how=How.ID,using = "id_state")
    private WebElement state;
    @FindBy(xpath = "//*[@id=\"id_state\"]/option[6]")
    private WebElement selectedStateOption;
    @FindBy(how=How.ID,using = "postcode")
    private WebElement zipCode;
    @FindBy(how=How.ID,using = "id_country")
    private WebElement country;
    @FindBy(xpath = "//*[@id=\"id_country\"]/option[2]")
    private WebElement countryOption;
    @FindBy(how=How.ID,using = "other")
    private WebElement otherTextBox;
    @FindBy(how=How.ID,using = "phone")
    private WebElement phone;
    @FindBy(how=How.ID,using = "phone_mobile")
    private WebElement phoneMobile;
    @FindBy(how=How.ID,using = "alias")
    private WebElement alias;
    @FindBy(how=How.ID,using = "submitAccount")
    private WebElement registerButton;

    public CreateAccountPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isCreateAccountFormOpened(){
        return registerButton.isDisplayed();
    }

    public void fillCreateAccountForm(){
        customerFirstname.sendKeys("Juan");
        customerLastname.sendKeys("Smith");
        customerPassword.sendKeys("Test123");
        //firstname.sendKeys("Juan");
        //lastname.sendKeys("Smith");
        address1.sendKeys("Park Avenue, CA 5045");
        city.sendKeys("California");
        state.click();
        selectedStateOption.click();
        zipCode.sendKeys("55555");
        country.click();
        countryOption.click();
        phoneMobile.sendKeys("6505551234");
        alias.sendKeys("MyHomeJuanSmith");
    }

    public void clickOnRegisterButton(){
        registerButton.click();
    }


}
