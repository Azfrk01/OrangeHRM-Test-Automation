package base;
import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.ExtentManager;
import utils.ScreenshotUtil;
public class BaseTest{
    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;
    @BeforeMethod
    public void setUp(Method method){
        System.out.println(">>> SETUP START");
        extent = ExtentManager.getInstance();
        test = extent.createTest(method.getName());
        WebDriverManager.chromedriver().browserVersion("LATEST").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("url"));
        test.log(Status.INFO,"Browser launched and navigated to URL: "+ ConfigReader.getProperty("url"));
    }
    protected void loginAsAdmin(){
        LoginPage login = new LoginPage(driver);
        login.login(
            ConfigReader.getProperty("username"),
            ConfigReader.getProperty("password")
        );
        DashboardPage dashboard = new DashboardPage(driver);
        if (!dashboard.isDashboardDisplayed()) {
            throw new RuntimeException("Dashboard not loaded after login");
        }
        test.log(Status.INFO, "Logged in and Dashboard verified");
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result){
        try{
            if (result.getStatus() == ITestResult.FAILURE){
                ScreenshotUtil screenshot = new ScreenshotUtil(driver);
                String path = screenshot.takeScreenshot(result.getName());
                test.log(Status.FAIL, result.getThrowable());
                test.addScreenCaptureFromPath(path);
            }else if(result.getStatus() == ITestResult.SUCCESS){
                test.log(Status.PASS, "Test Passed");
            } else if (result.getStatus() == ITestResult.SKIP) {
                test.log(Status.SKIP, result.getThrowable());
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if (extent != null){
                extent.flush();
            }
            if (driver != null){
                driver.quit();   // ✅ CORRECT
            }
        }
    }
}