package registerUserPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // URL
    String homePage = "http://automationexercise.com";

    // Locators

    // home page:
    private final By homeHeader = By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]");
    private final By signUpPage = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");



    // Actions:
    public HomePage navigateToTheWebSiteHomePage() {
        driver.navigate().to(homePage);

        return this;
    }

    public HomePage verifyHomePageVisibleSuccessfully() {
        // assert we are on the home page
        String expectedPageTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedPageTitle);
        // assert it's visible
        String HomeHeader = driver.findElement(homeHeader).getText();
        Assert.assertTrue(HomeHeader.contains("Home"));
        return this;
    }

    public HomePage clickOnSignUpPage() {
        driver.findElement(signUpPage).click();
        return this;
    }
}
