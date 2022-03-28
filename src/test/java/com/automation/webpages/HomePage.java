package com.automation.webpages;

import com.qa.Base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    //private WebDriver driver;
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
        PageFactory.initElements(driver,this);
    }

    @Step("Typing Search criteria")
    public void enterSearchCriteria(){
        searchTextBox.sendKeys("dress");
    }

    @Step("Search now")
    public void clickOnSearchIcon(){
        searchButton.click();
    }

    public void clickOnSignIn(){
        signInButton.click();
    }

}
