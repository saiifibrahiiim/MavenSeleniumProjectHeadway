import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterUserLinearDesing {

    WebDriver driver;

    @Test
    public void userRegister() {
        navigateToTheWebSiteHomePage();
        verifyHomePageVisibleSuccessfully();
        clickOnSignUpPage();
        verifyNewUserSignUpPageVisible();
        enterNewUserName_Email("sobhy", "sobh@hamdy.com");
        verifyEnterAccountInfoVisible();
        enterData(
                "Mrs", "hamdy123", "16", "12",
                "2016", "hamdy", "sobhy",
                "nezlt el seman", "Canada", "cairo",
                "cairo", "12344", "01234565788");
        createAccount();
    }

    @BeforeTest
    public void Btest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void Atest() {
        driver.quit();
    }

    // URL
    String homePage = "http://automationexercise.com";

    // Locators

    // home page:
    private final By homeHeader = By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]");
    private final By signUpPage = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");

    // SignUp page:
    private final By NewUserSignUp = By.xpath("//h2[contains(text(),'New User Signup!')]");
    private final By Name1 = By.xpath("//body/section[@id='form']/div[1]/div[1]/div[3]/div[1]/form[1]/input[2]");
    private final By Email1 = By.xpath("//body/section[@id='form']/div[1]/div[1]/div[3]/div[1]/form[1]/input[3]");
    private final By SignUpButton = By.xpath("//button[contains(text(),'Signup')]");

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

    // Actions:
    public void navigateToTheWebSiteHomePage() {
        driver.navigate().to(homePage);
    }

    public void verifyHomePageVisibleSuccessfully() {
        // assert we are on the home page
        String expectedPageTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedPageTitle);
        // assert it's visible
        String HomeHeader = driver.findElement(homeHeader).getText();
        Assert.assertTrue(HomeHeader.contains("Home"));
    }
    public void clickOnSignUpPage() {
        driver.findElement(signUpPage).click();
    }
//////////////////
    public void verifyNewUserSignUpPageVisible() {
        String NewUser = driver.findElement(NewUserSignUp).getText();
        Assert.assertTrue(NewUser.contains("Sign"));
    }

    public void enterNewUserName_Email(String Name, String Email) {
        driver.findElement(Name1).sendKeys(Name);
        driver.findElement(Email1).sendKeys(Email);
        driver.findElement(SignUpButton).click();
    }
///////////

    public void verifyEnterAccountInfoVisible() {
        String AccountInformationText = driver.findElement(AccountInformationTitle).getText();
        Assert.assertTrue(AccountInformationText.contains("ACCOUNT"));
    }

    private void enterData(String genderChoice, String Password, String Day, String Month, String Year,
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