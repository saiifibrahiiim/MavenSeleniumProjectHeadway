package registerUserTestPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import registerUserPOM.HomePage;
import registerUserPOM.SignUpPage;
import registerUserPOM.infoPage;

public class TestRegisterUser {
    WebDriver driver;
    HomePage home_o = new HomePage(driver);
    infoPage info_o = new infoPage(driver);
    SignUpPage sign_o = new SignUpPage(driver);


    @Test
    public void userRegister() {

        new HomePage(driver).navigateToTheWebSiteHomePage()
                            .verifyHomePageVisibleSuccessfully()
                            .clickOnSignUpPage();
        sign_o.verifyNewUserSignUpPageVisible();
        sign_o.enterNewUserName_Email("hamd","uskj@jhn");
        info_o.verifyEnterAccountInfoVisible();
        info_o.enterData(
                "Mrs", "hamdy123", "16", "12",
                "2016", "hamdy", "sobhy",
                "nezlt el seman", "Canada", "cairo",
                "cairo", "12344", "01234565788");
        info_o.createAccount();
    }



    @BeforeTest
    public void Btest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @AfterTest
    public void Atest() {
        driver.quit();
    }
}
