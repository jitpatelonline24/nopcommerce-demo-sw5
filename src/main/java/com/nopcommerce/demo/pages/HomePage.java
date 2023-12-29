package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Jitesh Patel
 */

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(linkText = "Log in")
    WebElement loginLink;
    //By loginLink = By.linkText("Log in");
    @CacheLookup
    @FindBy(linkText = "Register")
    WebElement registerLink;
    //By registerLink = By.linkText("Register");

    public void clickOnLoginLink(){
        clickOnElement(loginLink);
    }
    public void clickOnRegisterLink(){
        clickOnElement(registerLink);
    }

    @CacheLookup
    @FindBy(xpath = "//img[@alt='nopCommerce demo store']")
    WebElement nopCommerceLogo;

    @CacheLookup
    @FindBy(linkText = "Log out")
    WebElement logOut;
    public String getTextLogIn() {
        return getTextFromElement(loginLink);
    }

    public void clickOnLogOutLink() {
        clickOnElement(logOut);
    }
    @CacheLookup
    @FindBy(linkText = "//ul[@class = 'top-menu notmobile']")
    WebElement topMenu;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
    WebElement computers;

    public String getTextLogOut() {
        return getTextFromElement(logOut);
    }

    public void clickOnComputers() {
        clickOnElement(computers);
    }
    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']")
    WebElement electronics;
    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu mobile']//a[normalize-space()='Apparel']")
    WebElement apparel;

    public void clickOnElectronics() {
        clickOnElement(electronics);
    }

    public void clickOnApparel() {
        clickOnElement(apparel);
    }

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu mobile']//a[normalize-space()='Digital downloads']")
    WebElement digitalDownloads;
    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu mobile']//a[normalize-space()='Books']")
    WebElement books;
    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu mobile']//a[normalize-space()='Jewelry']")
    WebElement jewelry;
    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu mobile']//a[normalize-space()='Gift Cards']")
    WebElement giftCards;



    public void clickOnDigitalDownloads() {
        clickOnElement(digitalDownloads);

    }

    public void clickOnBooks() {
        clickOnElement(books);
    }

    public void clickOnJewelry() {
        clickOnElement(jewelry);

    }

    public void clickOnGiftCards() {
        clickOnElement(giftCards);
    }

    public void selectMenu(String menu) {
        List<WebElement> topMenu = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']//li//a"));
        for (WebElement tabs : topMenu) {
            if (menu.equalsIgnoreCase(tabs.getText())) {
                tabs.click();
                break;
            }
        }
    }

}
