package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class DashboardPage {

    private WebDriver driver;
    private WaitUtils wait;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WaitUtils(driver, 15);
    }

    @FindBy(css = "header .oxd-topbar-header-breadcrumb h6")
    private WebElement dashboardHeader;

    @FindBy(xpath = "//span[text()='PIM']")
    private WebElement pimMenu;

    public boolean isDashboardDisplayed() {
        wait.waitForVisibility(dashboardHeader);
        return dashboardHeader.isDisplayed();
    }

    public void goToPIM() {
        wait.waitForClickability(pimMenu);
        pimMenu.click();
    }
}
