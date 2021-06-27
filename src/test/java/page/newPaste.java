package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class newPaste {

    private static final String homepage_url = "https://pastebin.com";
    private final By textForm = By.id("postform-text");
    private final By pasteTitle = By.id("postform-name");
    private final By createBtn = By.xpath("//*[@class='btn -big']");
    private final By expirationDropdown = By.id("select2-postform-expiration-container");
    private final By expiration10Minutes = By.xpath("//*[@class='select2-results']//*[text()='10 Minutes']");
    private WebDriver driver;

    public newPaste(WebDriver driver) {
        this.driver = driver;
    }

    public newPaste openPage() {
        driver.get(homepage_url);
        return this;
    }

    public newPaste textForm() {
        WebElement pasteText = driver.findElement(textForm);
        pasteText.sendKeys("Hello from WebDriver");
        return this;
    }

    public newPaste expirationTime() {
        WebElement dropdown = driver.findElement(By.id("select2-postform-expiration-container"));
        dropdown.click();
        WebElement pasteExpirationDropdown = driver.findElement(By.xpath("//*[@class='select2-results']//*[text()='10 Minutes']"));
        pasteExpirationDropdown.click();
        return this;
    }


    public newPaste postFormName() {
        WebElement pasteName = driver.findElement(By.id("postform-name"));
        pasteName.sendKeys("helloweb");
        return this;
    }

    public newPaste clickToSave() {
        WebElement createButton = driver.findElement(By.xpath("//*[@class='btn -big']"));
        createButton.click();
        return this;
    }
}
