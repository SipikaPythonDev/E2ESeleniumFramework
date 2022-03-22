package capabilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver driver;
    public Properties prop;
    public WebDriver inintialiseDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("D:\\E2Eframework\\src\\main\\resources\\data.properties");
        prop.load(fis);
        String browsername = prop.getProperty("browser");


        if(browsername.equalsIgnoreCase("chrome")){

            System.setProperty("webdriver.firefox.driver", "D://chromedriver.exe");
            driver= new ChromeDriver();
            driver.get(prop.getProperty("url"));

        }else if(browsername.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.chrome.driver", "D://geekodriver.exe");
            driver= new ChromeDriver();
            driver.get(prop.getProperty("url"));

        }else if(browsername.equalsIgnoreCase("ie"))
        {

            System.setProperty("webdriver.ie.driver", "D://iedriver.exe");
            driver= new ChromeDriver();
            driver.get(prop.getProperty("url"));
        }
        //implicit wait will work for entire script
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }

    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
    {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source =ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
        FileUtils.copyFile(source,new File(destinationFile));
        return destinationFile;


    }
}
