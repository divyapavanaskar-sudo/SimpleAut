package utils;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtils {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    // ✅ Initialize report (runs once)
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

    // ✅ Create Test (Scenario level)
    public static void createTest(String testName) {
        ExtentTest extentTest = extent.createTest(testName);
        test.set(extentTest);
    }

    // ✅ Get current test (Thread-safe)
    public static ExtentTest getTest() {
        return test.get();
    }

    // ✅ Log step
    public static void logStep(String stepName) {
        getTest().info(stepName);
    }

    // ✅ Log pass
    public static void logPass(String message) {
        getTest().pass(message);
    }

    // ✅ Log fail
    public static void logFail(String message) {
        getTest().fail(message);
    }

    // ✅ Attach screenshot
    public static void attachScreenshot(String path) {
        try {
            getTest().addScreenCaptureFromPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ✅ Flush report (end of execution)
    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
