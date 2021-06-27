package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.newPaste;

public class ICanWin {

    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test (description = "ICanWin task")
    public void  pastebinHelloWebDriver()  {
         newPaste a = new newPaste(driver)
         .openPage()
         .textForm()
         .expirationTime()
         .postFormName()
         .clickToSave();
         }

    @AfterMethod (alwaysRun = true)
    public void browserClosure() {
         driver.quit();
         driver=null;

    }
}
