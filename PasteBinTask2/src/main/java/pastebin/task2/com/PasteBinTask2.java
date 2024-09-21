package pastebin.task2.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasteBinTask2 {
    WebDriverWait wait;
    WebDriver driver;

    @FindBy(id = "message")
    WebElement pasteArea;

    @FindBy(id = "pasteExpiration")
    WebElement pasteExpiry;

    @FindBy(xpath = "//option[@value='2hour']")
    WebElement expiryOption;

    @FindBy(id="sendbutton")
    WebElement createButton;

    @FindBy(id="pasteFormatter")
    WebElement formatButton;

    @FindBy(xpath = "//option[@value='syntaxhighlighting']")
    WebElement sourceCode;


    PasteBinTask2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    public PasteBinTask2 enterText() {
        pasteArea.sendKeys("""
                git config --global user.name  \"New Sheriff in Town\"
                git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")
                git push origin master --force"""
        );
        return this;
    }

    public PasteBinTask2 setExpiry() {

        pasteExpiry.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[@value='2hour']")));
        expiryOption.click();
        return this;
    }

    public PasteBinTask2 clickCreate(){
        createButton.click();
        return this;
    }

    public PasteBinTask2 setFormat(){
        formatButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[@value='syntaxhighlighting']")));
        formatButton.click();
        return this;
    }

}
