package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pasteMethods {

    private static final String homepage_url = "https://pastebin.com";
    private final By textForm = By.id("postform-text");
    private final By pasteTitle = By.id("postform-name");
    private final By createBtn = By.xpath("//*[@class='btn -big']");
    private final By expirationDropdown = By.id("select2-postform-expiration-container");
    private final By expiration10Minutes = By.xpath("//*[@class='select2-results']//*[text()='10 Minutes']");
    private WebDriver driver;

    public pasteMethods(WebDriver driver) {
        this.driver = driver;
    }

    public pasteMethods openPage() {
        driver.get(homepage_url);
        return this;
    }

    public pasteMethods textFormHello() {
        WebElement pasteText = driver.findElement(textForm);
        pasteText.sendKeys("Hello from WebDriver");
        return this;
    }

    public pasteMethods textFormCode() {
        WebElement pasteText = driver.findElement(textForm);
        pasteText.sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");
        return this;
    }

    public pasteMethods syntaxHighlight() {
        WebElement dropdown = driver.findElement(By.id("select2-postform-format-container"));
        dropdown.click();
        WebElement pasteExpirationDropdown = driver.findElement(By.xpath("(//*[@class='select2-results__option' and contains(text(),\"Bash\")])[1]"));
        pasteExpirationDropdown.click();
        return this;
    }

    public pasteMethods expirationTime() {
        WebElement dropdown = driver.findElement(By.id("select2-postform-expiration-container"));
        dropdown.click();
        WebElement pasteExpirationDropdown = driver.findElement(By.xpath("//*[@class='select2-results']//*[text()='10 Minutes']"));
        pasteExpirationDropdown.click();
        return this;
    }


    public pasteMethods postFormNameForHello() {
        WebElement pasteName = driver.findElement(By.id("postform-name"));
        pasteName.sendKeys("helloweb");
        return this;
    }

    public pasteMethods postFormNameForCode() {
        WebElement pasteName = driver.findElement(By.id("postform-name"));
        pasteName.sendKeys("how to gain dominance among developers");
        return this;
    }

    public pasteMethods clickToSave() {
        WebElement createButton = driver.findElement(By.xpath("//*[@class='btn -big']"));
        createButton.click();
        return this;
    }

    public pasteMethods verifyTitle() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.className("info-top")));
        String actualTitle = driver.findElement(By.xpath("//*[@class='info-top']/h1")).getText();
        String expectedTitle="git config --global user.name  \"New Sheriff in Town\"\ngit reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\ngit push origin master --force";
        return this;
    }

}
