package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.yaml.snakeyaml.error.Mark;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExtentReportManager {
    public static ExtentReports extentReports;

    public static ExtentReports createInstanceOfReports(String fileName, String documentTitle, String reportName) {
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(fileName);
        extentSparkReporter.config().setDocumentTitle(documentTitle);
        extentSparkReporter.config().setReportName(reportName);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setEncoding("utf-8");

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        return extentReports;
    }

    public static String getDynamicReportNameWithTimeStamp() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedTime = dateTimeFormatter.format(localDateTime);
        String reportName = "TestReport_" + formattedTime + ".html";
        return reportName;
    }

    public static void logPassDetails(String log) {
        ExtentReportListener.threadLocalExtentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
    }

    public static void logFailDetails(String log) {
        ExtentReportListener.threadLocalExtentTest.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
    }

    public static void logInfoDetails(String log) {
        ExtentReportListener.threadLocalExtentTest.get().info(MarkupHelper.createLabel(log, ExtentColor.GREY));
    }

    public static void logWarningDetails(String log) {
        ExtentReportListener.threadLocalExtentTest.get().warning(MarkupHelper.createLabel(log, ExtentColor.YELLOW));
    }

    public static void logExceptionDetails(String exceptionDetails){
        ExtentReportListener.threadLocalExtentTest.get().fail(exceptionDetails);
    }

    public static void logJson(String json) {
        ExtentReportListener.threadLocalExtentTest.get().pass(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
    }

    public static void logHeaders(List<Header> headers){

        String [][] arrayOfHeaders =
        headers.stream().map(header -> new String[] {header.getName(), header.getValue()})
                        .toArray(String [][] :: new);
        ExtentReportListener.threadLocalExtentTest.get().info(MarkupHelper.createTable(arrayOfHeaders));
    }
}
