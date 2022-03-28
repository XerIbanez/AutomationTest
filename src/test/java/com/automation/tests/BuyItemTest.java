package com.automation.tests;

import com.automation.webpages.*;

import com.qa.Base.BasePage;
import com.qa.listeners.TestAllureListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;

@Listeners({TestAllureListener.class})
public class BuyItemTest {
    public WebDriver driver;
    public BasePage basePage;



    @BeforeMethod
    public void setup(){
        basePage = new BasePage();
        driver = basePage.initialize_driver();

    }

    /*public void createAccount(HomePage home){
        //HomePage home=new HomePage(driver);
        home.clickOnSignIn();

        SignInPage signInPage=new SignInPage(driver);
        Assert.assertTrue(signInPage.isSignInPageOpened());
    }*/

    @Test(priority = 1)
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

    @AfterMethod
    public void close(){
        driver.quit();
    }

}
