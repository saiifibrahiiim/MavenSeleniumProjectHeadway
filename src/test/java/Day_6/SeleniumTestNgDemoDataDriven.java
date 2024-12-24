package Day_6 ;
import framework.JsonFileManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class SeleniumTestNgDemoDataDriven {

    WebDriver driver;
    JsonFileManager testData;

    @Test
    public void testSearch1() throws InterruptedException {
        driver.findElement(By.id("APjFqb")).sendKeys(testData.getTestData("test1.searchData1"), Keys.ENTER);

        String firstSearchResultText = driver.findElement(By.xpath("//*[@id=\"ixcYae\"]/div/div/div/div/div/div/div[1]/div/span/a/div/div/div/div[1]/span")).getText();
        Assert.assertTrue(firstSearchResultText.contains("Giza"));

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"ixcYae\"]/div/div/div/div/div/div/div[1]/div/span/a/h3")).click();
    }

    @Test
    public void testSearch2() {
        driver.findElement(By.id("APjFqb")).sendKeys(testData.getTestData("test2.searchData2"), Keys.ENTER);

        String firstSearchResultText = driver.findElement(By.xpath("//*[@id=\"ixcYae\"]/div/div/div/div/div/div/div[1]/div/span/a/div/div/div/div[1]/span")).getText();
        Assert.assertEquals(firstSearchResultText, "test2.expectedResults2");
    }


    /////////////////////////// Configurations

    @BeforeClass
    public void beforeClass (){
        testData = new JsonFileManager("src/test/resources/Test Data/testData.json");
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/ncr");
    }


    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}
