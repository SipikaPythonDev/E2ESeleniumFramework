package Academy;

import capabilities.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.LandingPage;
import page_objects.LoginPage;

import java.io.IOException;

public class HomePage extends Base {

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
    @Test()
    public void basePageNevigation()
    {
        landobj.newsLetterFrame();
        landobj.getLogin().click();
    }
    @Test(dataProvider = "getData",dependsOnMethods = "basePageNevigation")
    public void loginPageTest(String username, String Password, String text)  {


        logobj.getUname().sendKeys(username);
        logobj.getPass().sendKeys(Password);
        System.out.println(text);
        logobj.getLogBtn().click();

    }

    @AfterTest
    public void quitDriver()
    {
        driver.quit();
    }

    @DataProvider
    public Object[][] getData(){

        // Row stands for how many different data types test should run
        //coloumn stands for how many values per each test

        // Array size is 2
        // 0,1
        Object[][] data=new Object[2][3];
        //0th row
        data[0][0]="nonrestricteduser@qw.com";
        data[0][1]="123456";
        data[0][2]="Restrcited User";
        //1st row
        data[1][0]="restricteduser@qw.com";
        data[1][1]="456788";
        data[1][2]= "Non restricted user";

        return data;

    }
}
