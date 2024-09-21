package pastebin.task2.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PasteBinTask2Test {
    WebDriver driver;
    PasteBinTask2 pasteBinTask;


    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        pasteBinTask = new PasteBinTask2(driver);
        driver.get("https://zerobin.org/");
        driver.manage().window().maximize();
    }

    @Test(priority = 2)
    public void enterTextTest() {
        pasteBinTask.enterText();
    }

    @Test(priority = 1)
    public void setExpiryTest() {
        pasteBinTask.setExpiry();
    }

    @Test(priority = 3)
    public void clickCreateTest(){
        pasteBinTask.clickCreate();
    }

    @Test(priority =0)
    public void selectFormat(){
        pasteBinTask.setFormat();
    }

//    @AfterClass
//    public void tearDown() throws InterruptedException {
//        Thread.sleep(10000);
//        driver.quit();
//    }
}
