package testcase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import util.CommonUtil;

public class TC1 {


    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extentReports;
    public ExtentTest test;

    @BeforeTest
    public void setExtent() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/myReport.html");
        htmlReporter.config().setDocumentTitle("Auto Reports");
        htmlReporter.config().setReportName("Function Report");
        htmlReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);

        extentReports.setSystemInfo("Host", "Localhost");
        extentReports.setSystemInfo("OS", "Windows 10");

    }

    @AfterTest
    public void terminateExtent() {
        extentReports.flush();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals(1, 1);
    }


    @Test
    public void testcase2() {
        System.out.println(CommonUtil.getProjectPath());
        Assert.assertEquals(1, 1);
    }


    @Test
    public void extendTest() {
        test = extentReports.createTest("extendTest");
        Assert.assertEquals(1, 1);
    }


    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL,"Testcase failed: " + result.getName());
            test.log(Status.FAIL,"Testcase failed: " + result.getThrowable());

        }else if(result.getStatus() == ITestResult.SKIP){
            test.log(Status.SKIP,"Testcase skipped: " + result.getName());
        }else if(result.getStatus() == ITestResult.SUCCESS){
            test.log(Status.PASS,"Testcase passed is: " + result.getName());
        }
    }
}
