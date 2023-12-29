package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.BuildYourOwnComputerPage;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.DesktopsPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

public class ComputerPageTest extends BaseTest {
    HomePage homePage = new HomePage();
    ComputerPage computerPage = new ComputerPage();
    DesktopsPage desktopsPage = new DesktopsPage();
    BuildYourOwnComputerPage buildYourOwnComputerPage = new BuildYourOwnComputerPage();

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        computerPage = new ComputerPage();
        desktopsPage = new DesktopsPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToComputerPageSuccessfully() {
        // Click on Computer tab
        homePage.clickOnComputers();
        // Verify "Computers" text
        Assert.assertEquals(computerPage.verifyComputerText(), "Computers");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        // Click on Computer tab
        homePage.clickOnComputers();
        Thread.sleep(2000);
        // Click on Desktops link
        computerPage.clickOnDesktops();
        // Verify "Desktops" text
        Assert.assertEquals(desktopsPage.verifyTextDesktops(), "Desktops");

    }
    @Test(groups = {"regression"},dataProvider = "Dataset",dataProviderClass = TestData.class)
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software) throws InterruptedException {
        // Click on Computer tab
        homePage.clickOnComputers();
        Thread.sleep(2000);
        // Click on Desktops link
        computerPage.clickOnDesktops();
        // Click on product name "Build your own computer"
        desktopsPage.clickOnBuildYourOwnComputer();
        // Select processor "processor"
        buildYourOwnComputerPage.selectProcessor(processor);
        // Select RAM "ram"
        buildYourOwnComputerPage.selectRAM(ram);
        // Select HDD "hdd"
        buildYourOwnComputerPage.selectHDD(hdd);
        // Select OS "os"
        buildYourOwnComputerPage.selectOS(os);
        // Select Software "software"
        buildYourOwnComputerPage.clickOnCheckBox3(software);
        // Click on "ADD TO CART" Button
        buildYourOwnComputerPage.clickOnAddToCart();
        // Verify message "The product has been added to your shopping cart"
        String expectedMsg = "The product has been added to your shopping cart";
        String actualMsg = buildYourOwnComputerPage.verifyTextProductAdded();
        Assert.assertEquals(expectedMsg, actualMsg);
    }
}