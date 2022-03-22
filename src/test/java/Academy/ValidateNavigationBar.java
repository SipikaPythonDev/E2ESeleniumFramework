package Academy;

import capabilities.Base;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_objects.LandingPage;
import page_objects.LoginPage;

import java.io.IOException;

public class ValidateNavigationBar extends Base {

    LandingPage landobj;
    @BeforeTest
    public void initObj() throws IOException
    {
        driver = inintialiseDriver();
        //driver.get("http://qaclickacademy.com");
        landobj = new LandingPage(driver);
       // logobj = new LoginPage(driver);
    }
    @Test
    public void validateNavBar()
    {
        boolean actual = landobj.getNavBar().isDisplayed();
        Assert.assertTrue(actual);
        System.out.println("Validate nav Bar");
    }

    @AfterTest
    public void quitDriver()
    {
        driver.quit();
    }
}
