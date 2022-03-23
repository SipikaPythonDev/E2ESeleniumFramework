package Academy;

import capabilities.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_objects.LandingPage;
import page_objects.LoginPage;

import java.io.IOException;

public class ValidateTitle extends Base {

    WebDriver driver;
    LandingPage landobj;
    LoginPage logobj;

    @BeforeTest
    public void initObj() throws IOException
    {
        driver = inintialiseDriver();
        //driver.get("http://qaclickacademy.com");
        landobj = new LandingPage(driver);
        logobj = new LoginPage(driver);
    }

    @Test
    public void validateAppTitle() throws IOException
    {

        //one is inheritance

        //compare the text from the browser with actual text.- Error..
        Assert.assertEquals(landobj.getTitle().getText(), "FEATURED COURSE");
        //log.info("Successfully validated Text message");
        System.out.println("Test completed");


    }

    @AfterTest
    public void quitDriver()
    {
        driver.quit();
    }
}
