package com.automation.webpages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class SearchResultsPage {
    private WebDriver driver;

    @FindBy(xpath="//*[@id=\"center_column\"]/h1/span[2]")
    private WebElement resultsFound;

    @FindBy(how= How.ID,using = "selectProductSort")
    private WebElement sortResults;

    @FindBy(xpath = "//*[@id=\"selectProductSort\"]/option[2]")
    private WebElement selectOptionLowerFirst;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]/span")
    private WebElement addItemToCart;

    //@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span/text()")
    //@FindBy(how=How.CSS,using = "btn btn-default button button-medium")
    //@FindBy(className = "btn btn-default button button-medium")
    //@FindBy(xpath = "//*[text()='Proceed to checkout']")
    @FindBy(linkText = "Proceed to checkout")
    private WebElement checkOutButton;

    @FindBy(className = "shopping_cart")
    private WebElement shoppingCartButton;

    //Constructor
    public SearchResultsPage(WebDriver driver){
        this.driver=driver;

        //Initialize Elements
        PageFactory.initElements(driver,this);
    }
    @Step("Verifying if Results Page is displayed")
    public boolean isPageOpened(){
        return resultsFound.getText().toString().contains("7 results have been found.123456");
    }

    /*public void sortResultsLowestFirst(){
        try{
            sortResults.selectByValue("price:asc");
        }
        catch (NullPointerException e){
            System.out.println("NullPointerException thrown!");
        }

    }*/
    @Step("Sorting Results by Lowest First")
    public void sortResultsLowestFirst(){
        sortResults.click();
        selectOptionLowerFirst.click();
    }
    @Step("Adding item to Cart")
    public void addFirstItemToCart(){

        addItemToCart.click();
    }
    @Step("Click on Checkout Button")
    public void clickOnCheckoutButton(){
        checkOutButton.click();
    }

    public void clickShoppingCartButton(){
        shoppingCartButton.click();
    }




}
