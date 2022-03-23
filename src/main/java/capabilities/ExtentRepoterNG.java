package capabilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ExtentRepoterNG {

    static ExtentReports extent;

   public static ExtentReports getReportObject()

    {

        String path =System.getProperty("user.dir")+"\\reports\\index1.html";

        try {
            FileUtils.deleteDirectory(new File(System.getProperty("user.dir")+"\\reports"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent =new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Sipika");
       return extent;

    }
}
