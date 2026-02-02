package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import utils.ConfigReader;
import com.aventstack.extentreports.Status;
public class LoginTest extends BaseTest{
    @Test
    public void validLoginTest(){
        try{
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
            );
            // ✅ Assertion using WaitUtils inside page
            Assert.assertTrue(
                loginPage.isDashboardDisplayed(),
                "Dashboard page is not displayed after login"
            );
            test.log(Status.PASS, "Valid login test passed");
        } catch (Exception e){
            test.log(Status.FAIL, "Valid login test failed: " + e.getMessage());
            throw e; // Let TestNG handle screenshot and failure
        }
    }
    @Test
    public void invalidLoginTest(){
        try {
            LoginPage login = new LoginPage(driver);
            login.login("wrongUser", "wrongPass");
            // Assert that dashboard is NOT displayed
            try{
                Assert.assertFalse(login.isDashboardDisplayed(), "Dashboard should not appear for invalid login");
            }catch(Exception e){
                // Element not found → expected behavior
                Assert.assertTrue(true);
            }
            test.log(Status.PASS, "Invalid login test passed");
        }catch(Exception e){
            test.log(Status.FAIL, "Invalid login test failed: " + e.getMessage());
            throw e;
        }
    }
}