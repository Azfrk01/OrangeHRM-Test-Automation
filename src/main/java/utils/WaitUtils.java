package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class WaitUtils{
    private WebDriver driver;
    private WebDriverWait wait;
    public WaitUtils(WebDriver driver, int timeOutInSeconds){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
    }
    // Wait until element is visible
    public void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    // Wait until element is clickable
    public void waitForClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitForClickability(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    // Wait until URL contains a value
    public void waitForURLContains(String value){
        wait.until(ExpectedConditions.urlContains(value));
    }
}