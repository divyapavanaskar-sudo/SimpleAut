package utils;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtils {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    public static void initReport() {

        if (extent == null) {

            ExtentSparkReporter spark = new ExtentSparkReporter("reports/extent-report.html");

            spark.config().setReportName("Automation Test Report");
            spark.config().setDocumentTitle("Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Tester", "Divya");
            extent.setSystemInfo("Environment", "QA");
        }
    }

    public static void createTest(String testName) {
        ExtentTest extentTest = extent.createTest(testName);
        test.set(extentTest);
    }

    public static ExtentTest getTest() {
        return test.get();
    }

   public static void logStep(String stepName) {
        getTest().info(stepName);
    }

    public static void logPass(String message) {
        getTest().pass(message);
    }

    public static void logFail(String message) {
        getTest().fail(message);
    }

    public static void attachScreenshot(String path) {
        try {
            getTest().addScreenCaptureFromPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
