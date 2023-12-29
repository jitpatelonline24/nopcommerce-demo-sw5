package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegisterPageTest extends BaseTest {

    RegisterPage registerPage = new RegisterPage();
    HomePage homePage = new HomePage();

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"sanity", "smoke"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //Click on Register Link
        homePage.clickOnRegisterLink();
        // Verify "Register" text
        registerPage.verifyRegisterText();
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        // Click on Register Link
        homePage.clickOnRegisterLink();
        // Click on "REGISTER" button
        registerPage.clickOnRegisterButton();
        // Verify the error message "First name is required."
        Assert.assertEquals(registerPage.verifyTextFirstNameIsRequired(), "First name is required.");
        // Verify the error message "Last name is required."
        Assert.assertEquals(registerPage.verifyTextLastNameIsRequired(), "Last name is required.");
        // Verify the error message "Email is required."
        Assert.assertEquals(registerPage.verifyTextEmailIsRequired(), "Email is required.");
        // Verify the error message "Password is required."
        Assert.assertEquals(registerPage.verifyTextPasswordIsRequired(), "Password is required.");
        // Verify the error message "Password is required."
        Assert.assertEquals(registerPage.verifyTextConfirmPasswordIsRequired(), "Password is required.");
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully() {
        // Click on Register Link
        homePage.clickOnRegisterLink();
        // Select gender "Female"
        registerPage.selectGenderFemale();
        // Enter firstname
        registerPage.enterFirstName("Test");
        // Enter lastname
        registerPage.enterLastName("Data");
        // Select day
        registerPage.selectDayOfBirth("15");
        // Select month
        registerPage.selectDateOfBirthMonth("July");
        // Select year
        registerPage.selectDateOfBirthYear("2001");
        // Enter email
        Random random = new Random();
        registerPage.enterEmailId("test"+ random.nextInt()+"@gmail.com");
        // Enter password
        registerPage.enterPassword("Abcd1234");
        // Enter Confirm Password
        registerPage.enterConfirmPassword("Abcd1234");
        // Click on "REGISTER" button
        registerPage.clickOnRegisterButton();
        // Verify message "Your registration completed"
        Assert.assertEquals(registerPage.verifyTextRegistrationComplete(), "Your registration completed");

    }
    }
