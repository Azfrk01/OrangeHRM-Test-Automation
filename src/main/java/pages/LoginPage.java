package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtils;
public class LoginPage{
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(name="username")
    WebElement username;
    @FindBy(name="password")
    WebElement password;
    @FindBy(xpath="//button[@type='submit']")
    WebElement loginBtn;
    @FindBy(xpath="//h6[text()='Dashboard']")
    private WebElement dashboardHeader;

    public void enterUsername(String user){
        username.sendKeys(user);
    }
    public void enterPassword(String pass){
        password.sendKeys(pass);
    }
    public void clickLogin(){
        loginBtn.click();
    }
    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }
    public boolean isDashboardDisplayed() {
        WaitUtils wait = new WaitUtils(driver, 10); // 10 second timeout
        wait.waitForVisibility(dashboardHeader);
        return dashboardHeader.isDisplayed();
        }
}
