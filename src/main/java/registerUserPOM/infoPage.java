package registerUserPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class infoPage {
    WebDriver driver;
    public infoPage(WebDriver driver) {
        this.driver = driver;
    }

    // Create account page:
    private final By AccountInformationTitle = By.xpath("//*[@id=\"form\"]/div/div/div/div/h2/b");
    private final By mr = By.xpath("//input[@id='id_gender1']");
    private final By mrs = By.xpath("//input[@id='id_gender2']");
    private final By password = By.xpath("//input[@id='password']");
    private final By day = By.xpath("//select[@id='days']");
    private final By month = By.xpath("//select[@id='months']");
    private final By year = By.xpath("//select[@id='years']");
    private final By newsletter = By.xpath("//input[@id='newsletter']");
    private final By specialOffer = By.xpath("//input[@id='optin']");
    private final By firstName = By.xpath("//input[@id='first_name']");
    private final By lastName = By.xpath("//input[@id='last_name']");
    private final By country = By.xpath("//select[@id='country']");
    private final By address = By.xpath("//input[@id='address1']");
    private final By state = By.xpath("//input[@id='state']");
    private final By city = By.xpath("//input[@id='city']");
    private final By zipcode = By.xpath("//input[@id='zipcode']");
    private final By mobileNumber = By.xpath("//input[@id='mobile_number']");
    private final By createAccountButton = By.xpath("//button[contains(text(),'Create Account')]");


    //ACtions :

    public void verifyEnterAccountInfoVisible() {
        String AccountInformationText = driver.findElement(AccountInformationTitle).getText();
        Assert.assertTrue(AccountInformationText.contains("ACCOUNT"));
    }

    public void enterData(String genderChoice, String Password, String Day, String Month, String Year,
                          String FirstName, String LastName, String Address,
                          String Country, String State, String City, String Zipcode,
                          String MobileNumber) {

        if (genderChoice.equalsIgnoreCase("Mr")) {
            driver.findElement(mr).click();
        } else if (genderChoice.equalsIgnoreCase("Mrs")) {
            driver.findElement(mrs).click();
        } else {
            throw new IllegalArgumentException("Invalid gender choice or female checkbox locator not set.");
        }

        driver.findElement(password).sendKeys(Password);
        driver.findElement(day).sendKeys(Day);
        driver.findElement(month).sendKeys(Month);
        driver.findElement(year).sendKeys(Year);
        driver.findElement(newsletter).click();
        driver.findElement(specialOffer).click();
        driver.findElement(firstName).sendKeys(FirstName);
        driver.findElement(lastName).sendKeys(LastName);
        driver.findElement(address).sendKeys(Address);
        driver.findElement(country).sendKeys(Country);
        driver.findElement(state).sendKeys(State);
        driver.findElement(city).sendKeys(City);
        driver.findElement(zipcode).sendKeys(Zipcode);
        driver.findElement(mobileNumber).sendKeys(MobileNumber);
    }

    public void createAccount() {
        driver.findElement(createAccountButton).click();
    }
}

