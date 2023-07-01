package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class ExtentReportListener implements ITestListener {

    private static ExtentReports extentReports;
    public static ThreadLocal<ExtentTest> threadLocalExtentTest = new ThreadLocal<ExtentTest>();

    public void onStart(ITestContext context) {

        String filename =
                ExtentReportManager.getDynamicReportNameWithTimeStamp();
        String fullPath =
                System.getProperty("user.dir") + "\\reports\\" + filename;
        extentReports =
                ExtentReportManager.createInstanceOfReports(fullPath, "API Automation Report", "Test Execution Report");
    }

    public void onFinish(ITestContext context) {
        if (extentReports != null) {
            extentReports.flush();
        }
    }

    public void onTestStart(ITestResult result) {
        ExtentTest test =
                extentReports.createTest("Test Name" + result.getClass().getName() + "---" + result.getMethod().getMethodName());
        threadLocalExtentTest.set(test);
    }

    public void onTestFailure(ITestResult result) {
        ExtentReportManager.logFailDetails(result.getThrowable().getMessage()); //This will display failure message like Assertion

        String stackTrace = Arrays.toString(result.getThrowable().getStackTrace());
        stackTrace = stackTrace.replaceAll(",", "<br>");
        String formattedStackTrace =
                "<details>\n" +
                        "  <summary>Click Here to expand</summary>\n" +
                        "  <p>" + stackTrace + "</p>\n" +
                        "</details>";

        ExtentReportManager.logExceptionDetails(formattedStackTrace);    //Print StackTrace
    }
}
