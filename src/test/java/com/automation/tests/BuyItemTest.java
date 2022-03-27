package com.automation.tests;

import com.automation.webpages.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BuyItemTest {
    WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromeWebDriver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /*public void createAccount(HomePage home){
        //HomePage home=new HomePage(driver);
        home.clickOnSignIn();

        SignInPage signInPage=new SignInPage(driver);
        Assert.assertTrue(signInPage.isSignInPageOpened());
    }*/

    @Test
    public void buyItem(){
        //Create object of HomePage Class
        HomePage home=new HomePage(driver);
        home.enterSearchCriteria();
        home.clickOnSearchIcon();

        SearchResultsPage pageWithResults=new SearchResultsPage(driver);
        Assert.assertTrue(pageWithResults.isPageOpened());
        pageWithResults.sortResultsLowestFirst();
        pageWithResults.addFirstItemToCart();
        //pageWithResults.clickShoppingCartButton();
        pageWithResults.clickOnCheckoutButton();

        CartPage cartPage=new CartPage(driver);
        Assert.assertTrue(cartPage.isCartOpened());
        cartPage.clickOnCheckoutButton();

        SignInPage signInPageTab = new SignInPage(driver);
        Assert.assertTrue(signInPageTab.isSignInPageOpened());
        signInPageTab.enterEmailToCreateAccount();
        signInPageTab.clickOnCreateAccountButton();

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        Assert.assertTrue(createAccountPage.isCreateAccountFormOpened());
        createAccountPage.fillCreateAccountForm();
        createAccountPage.clickOnRegisterButton();

        AddressPage addressPage=new AddressPage(driver);
        Assert.assertTrue(addressPage.isAddressPageOpened());
        addressPage.clickOnProceedButton();

        ShippingPage shippingPage=new ShippingPage(driver);
        Assert.assertTrue(shippingPage.isShippingPageOpened());
        shippingPage.clickOnTermsOfService();
        shippingPage.clickOnProceedButton();

        PaymentPage paymentPage=new PaymentPage(driver);
        Assert.assertTrue(paymentPage.isPaymentPageOpened());
        paymentPage.clickOnPayByBankWire();

        OrderSummaryPage orderSummaryPage=new OrderSummaryPage(driver);
        Assert.assertTrue(orderSummaryPage.isOrderSummaryPageOpened());

    }

    @After
    public void close(){
        driver.close();
    }

}
