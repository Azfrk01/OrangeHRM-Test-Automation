package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class PIMPage {

    private WebDriver driver;
    private WaitUtils wait;

    public PIMPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WaitUtils(driver, 10);
    }

    // ----------- PIM MENU -----------
    @FindBy(xpath = "//span[text()='PIM']")
    private WebElement pimMenu;

    @FindBy(xpath = "//a[@href='/web/index.php/pim/addEmployee']")
    private WebElement addEmployeeMenu;

    // ----------- ADD EMPLOYEE FORM -----------
    @FindBy(name = "firstName")
    private WebElement firstName;

    @FindBy(name = "lastName")
    private WebElement lastName;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    // ----------- ACTIONS -----------

    /** Open PIM → Add Employee page */
    public void openAddEmployeePage() {
        wait.waitForClickability(pimMenu);
        pimMenu.click();

        wait.waitForClickability(addEmployeeMenu);
        addEmployeeMenu.click();
    }

    /** Fill employee details */
    public void enterEmployeeDetails(String fName, String lName) {
        wait.waitForVisibility(firstName);
        firstName.clear();
        firstName.sendKeys(fName);

        lastName.clear();
        lastName.sendKeys(lName);
    }

    /** Click Save button */
    public void clickSave() {
        wait.waitForClickability(saveButton);
        saveButton.click();
    }

    /** Complete Add Employee flow */
    public void addEmployee(String fName, String lName) {
        openAddEmployeePage();
        enterEmployeeDetails(fName, lName);
        clickSave();
    }
}
