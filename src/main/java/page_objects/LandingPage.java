package page_objects;

import capabilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends Base {

    WebDriver driver;
    By login = new By.ByCssSelector("a[href*='sign_in'");
    public LandingPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement getLogin()
    {
        return driver.findElement(login);
    }

    public void newsLetterFrame()
    {
        WebDriverWait w = new WebDriverWait(driver,5);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sumome-react-wysiwyg-component sumome-react-wysiwyg-popup-background sumome-react-wysiwyg-background']")));
        System.out.println("Running");
        driver.findElement(By.xpath("//button[text()='NO THANKS']")).click();

    }

    public WebElement getTitle()
    {
        return driver.findElement(By.cssSelector(".text-center>h2"));
    }

    public WebElement getNavBar()
    {
        return driver.findElement(By.cssSelector("nav[class='navbar-collapse collapse']"));
    }

}
