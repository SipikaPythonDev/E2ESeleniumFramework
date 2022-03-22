package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getUname()
    {
        return driver.findElement(By.id("user_email"));
    }

    public WebElement getPass()
    {
        return driver.findElement(By.id("user_password"));
    }

    public WebElement getLogBtn()
    {
        return driver.findElement(By.cssSelector("input[value='Log In']"));
    }
}
