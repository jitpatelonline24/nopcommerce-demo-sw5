package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by Jitesh Patel
 */
@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;

    // Page Factory

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test(groups = "sanity")
    public void verifyUserShouldNavigateToLoginPage() {
        homePage.clickOnLoginLink();
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.getWelcomeText();
        Assert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");
    }

    @Test(groups = {"sanity", "smoke"})
    public void verifyErrorMessageWithInvalidCredentials() {
        homePage.clickOnLoginLink();
        loginPage.enterEmailId("prime123@gmail.com");
        loginPage.enterPassword("prime123");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals( expectedErrorMessage, actualErrorMessage,"Error message not displayed");
    }
    @Test(groups = {"smoke","regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() {
        //Click on login link-->Enter EmailId--->Enter Password-->Click on Login Button
        loginPage.logIn("test1212@gmail.com", "Abcd1234");
        //Verify that LogOut link is display
        Assert.assertEquals(homePage.getTextLogOut(), "Log out");
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogOutSuccessFully() {
        //Click on login link-->Enter EmailId--->Enter Password-->Click on Logout Button
        loginPage.logIn("test1212@gmail.com", "Abcd1234");
        //Click on LogOut Link
        homePage.clickOnLogOutLink();
        //Verify that LogIn Link Display
        Assert.assertEquals(homePage.getTextLogIn(), "Log in");
    }

}
