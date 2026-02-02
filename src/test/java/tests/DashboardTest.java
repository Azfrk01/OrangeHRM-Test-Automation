package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import pages.DashboardPage;
import utils.ConfigReader;
import com.aventstack.extentreports.Status;
public class DashboardTest extends BaseTest{
    @Test
    public void dashboardVisibleAfterLogin(){
    	loginAsAdmin();
        try{
            // Step 1: Login
            LoginPage login = new LoginPage(driver);
            login.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
            );
            // Step 2: Dashboard page
            DashboardPage dashboard = new DashboardPage(driver);
            Assert.assertTrue(dashboard.isDashboardDisplayed(), "Dashboard header is not displayed");
            test.log(Status.PASS, "Dashboard test passed");
        }catch(Exception e){
            test.log(Status.FAIL, "Dashboard test failed: " + e.getMessage());
            throw e;
        }
    }
}