package firstTry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ICanWin1 {

    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup (){
        driver = new ChromeDriver();
    }

    @Test (description = "ICanWin task")
    public void  pastebinHelloWebDriver() throws InterruptedException {

        driver.get("https://pastebin.com");

        WebElement pasteText = driver.findElement(By.id("postform-text"));
        pasteText.sendKeys("Hello from WebDriver");

        WebElement dropdown = driver.findElement(By.id("select2-postform-expiration-container"));
        dropdown.click();
        WebElement pasteExpirationDropdown = driver.findElement(By.xpath("//*[@class='select2-results']//*[text()='10 Minutes']"));
        pasteExpirationDropdown.click();

        WebElement pasteName = driver.findElement(By.id("postform-name"));
        pasteName.sendKeys("helloweb");

        WebElement createButton = driver.findElement(By.xpath("//*[@class='btn -big']"));
        createButton.click();
    }
    @AfterMethod (alwaysRun = true)
    public void browserClosure() {
         driver.quit();
         driver=null;

    }
}
