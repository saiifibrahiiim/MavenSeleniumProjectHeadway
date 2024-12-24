import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterUser {

    WebDriver driver = new ChromeDriver();

    @Test
    public void test1() throws InterruptedException {
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com");
        String expectedPageTitle = "Automation Exercise";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(actualTitle,expectedPageTitle);
        String Home = driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]")).getText();
        Assert.assertTrue(Home.contains("Home"));
        driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]")).click();
        String SignUpPage = driver.findElement(By.xpath("//h2[contains(text(),'New User Signup!')]")).getText();
        Assert.assertTrue(SignUpPage.contains("Sign"));
        driver.findElement(By.xpath("//body/section[@id='form']/div[1]/div[1]/div[3]/div[1]/form[1]/input[2]")).sendKeys("Saif");
        driver.findElement(By.xpath("//body/section[@id='form']/div[1]/div[1]/div[3]/div[1]/form[1]/input[3]")).sendKeys("haamd_hamoda@yahoo.com");
        driver.findElement(By.xpath("//button[contains(text(),'Signup')]")).click();
        String AccountInformation = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/h2/b")).getText();
        Assert.assertTrue(AccountInformation.contains("ACC"));
        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("hamdy123");
        driver.findElement(By.xpath("//select[@id='days']")).sendKeys("19");
        driver.findElement(By.xpath("//select[@id='months']")).sendKeys("1");
        driver.findElement(By.xpath("//select[@id='years']")).sendKeys("2000");
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        driver.findElement(By.xpath("//input[@id='optin']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Saif");
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("SOFA");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("cairo");
        driver.findElement(By.xpath("//select[@id='country']")).sendKeys("india");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("cairo");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("cairo");
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("124");
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("1234567");
        driver.findElement(By.xpath("//button[contains(text(),'Create Account')]")).click();
        String AccountCreatedSuccessfully = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b")).getText();
        Assert.assertTrue(AccountCreatedSuccessfully.contains("CREATED"));
        Thread.sleep(2000);
        driver.close();

    }
}
