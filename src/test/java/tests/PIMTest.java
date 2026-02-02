package tests;

import base.BaseTest;
import pages.PIMPage;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

public class PIMTest extends BaseTest {

    @Test
    public void addEmployeeTest() {

        // LOGIN ONCE (handled by BaseTest)
        loginAsAdmin();

        try {
            PIMPage pimPage = new PIMPage(driver);
            pimPage.addEmployee("John", "Doe");

            test.log(Status.PASS, "Employee added successfully");

        } catch (Exception e) {
            test.log(Status.FAIL, "Add Employee test failed: " + e.getMessage());
            throw e;
        }
    }
}
