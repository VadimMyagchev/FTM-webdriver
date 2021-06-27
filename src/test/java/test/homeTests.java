package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.pasteMethods;

public class homeTests {

    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

//    @Test (description = "I Can Win")
//    public void  pastebinHelloWebDriver()  {
//         pasteMethods a = new pasteMethods(driver)
//         .openPage()
//         .textFormHello()
//         .expirationTime()
//         .postFormNameForHello()
//         .clickToSave();
//         }

    @Test (description = "Bring it on")
    public void  pastebinVerifyAssertionWebDriver() throws InterruptedException {
          pasteMethods a = new pasteMethods(driver)
         .openPage()
         .textFormCode()
         .syntaxHighlight()
         .expirationTime()
         .postFormNameForCode()
         .clickToSave();
    //     .verifyTitle();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.className("info-top")));
        String actualTitle = driver.findElement(By.xpath("//*[@class='info-top']/h1")).getText();
        String actualText = driver.findElement(By.xpath("//*[@class='info-top']/h1")).getText();

        String colorString = driver.findElement(By.id("foo")).getAttribute("class");
        String[] arrColor = colorString .split("#");
        assertTrue(arrColor[1].equals("FFFFFF"));

        String expectedTitle="how to gain dominance among developers";
        String expectedText="git config --global user.name  \"New Sheriff in Town\"\ngit reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\ngit push origin master --force";

        Assert.assertTrue(actualTitle.contains (expectedTitle), "Page title is not correct");
        Assert.assertTrue(actualText.contains (expectedText), "Page text is not correct");
        Assert.assertTrue(actualColor.contains (expectedColor), "Text color is not correct");
    }

//    @AfterMethod (alwaysRun = true)
//    public void browserClosure() {
//         driver.quit();
//         driver=null;
//    }
}
