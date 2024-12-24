package registerUserPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignUpPage {
    WebDriver driver;
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    // locators:

    private final By NewUserSignUp = By.xpath("//h2[contains(text(),'New User Signup!')]");
    private final By Name1 = By.xpath("//body/section[@id='form']/div[1]/div[1]/div[3]/div[1]/form[1]/input[2]");
    private final By Email1 = By.xpath("//body/section[@id='form']/div[1]/div[1]/div[3]/div[1]/form[1]/input[3]");
    private final By SignUpButton = By.xpath("//button[contains(text(),'Signup')]");

    //Actions :

    public void verifyNewUserSignUpPageVisible() {
        String NewUser = driver.findElement(NewUserSignUp).getText();
        Assert.assertTrue(NewUser.contains("Sign"));
    }

    public void enterNewUserName_Email(String Name, String Email) {
        driver.findElement(Name1).sendKeys(Name);
        driver.findElement(Email1).sendKeys(Email);
        driver.findElement(SignUpButton).click();
    }

}
