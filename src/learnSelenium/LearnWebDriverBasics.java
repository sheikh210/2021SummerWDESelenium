package learnSelenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LearnWebDriverBasics {

        /*
    WebDriver Waits
        1 - Implicit Wait
        2 - Explicit Wait
        3 - Fluent Wait
     */

    String absPath = System.getProperty("user.dir");
    String relativePath = "/resources/WebDrivers/Windows/chromedriver.exe";
    String windowsChromeDriverPath = absPath + relativePath;
    String website = "https://www.sephora.com";
    static ChromeDriver driver;
    static WebDriverWait webDriverWait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", windowsChromeDriverPath);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get(website);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    public void testSearch() {
        webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#site_search_input"))));

        WebElement searchInputBox = driver.findElement(By.cssSelector("#site_search_input"));

        searchInputBox.sendKeys("eyeliner");
        searchInputBox.sendKeys(Keys.ENTER);

        Wait<ChromeDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class);

        fluentWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.css-9cc1en.e65zztl0 h1 span"))));
        WebElement searchResults = driver.findElement(By.cssSelector("div.css-9cc1en.e65zztl0 h1 span"));

        String actualText = searchResults.getText();
        String expectedText = "141 results";

        Assert.assertEquals("Search result quantity does not match", expectedText, actualText);
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}

