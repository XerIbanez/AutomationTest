package com.automation.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    //Page URL
    private static String PAGE_URL="https://www.automationpractice.com";

    //Locators
    // Search Text Box
    @FindBy(how=How.ID,using="search_query_top")
    private WebElement searchTextBox;

    @FindBy(how = How.NAME,using="submit_search")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    private WebElement signInButton;

    //Constructor
    public HomePage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver,this);
    }

    public void enterSearchCriteria(){
        searchTextBox.sendKeys("dress");
    }

    public void clickOnSearchIcon(){
        searchButton.click();
    }

    public void clickOnSignIn(){
        signInButton.click();
    }

}
