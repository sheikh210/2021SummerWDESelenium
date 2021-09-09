package learnSelenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

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
    String website = "https://courses.letskodeit.com/practice";
    static ChromeDriver driver;
    static WebDriverWait webDriverWait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", windowsChromeDriverPath);

        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get(website);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    // Let's Kode It Element Practice
    @Test
    public void testKodeItComboBox() throws Exception {
        WebElement comboBox = driver.findElement(By.id("carselect"));
        Select select = new Select(comboBox);
//        select.selectByValue("benz");
//        select.selectByVisibleText("Benz");
        select.selectByIndex(2);

        Thread.sleep(3000);
    }

    @Test
    public void testKodeItMultiSelectComboBox() {
        WebElement multiComboBox = driver.findElement(By.id("multiple-select-example"));
        Select select = new Select(multiComboBox);
        select.selectByIndex(1);

        webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath("//option[@value=\"orange\"]"), true));

        select.selectByIndex(0);

        webDriverWait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath("//option[@value=\"apple\"]"), true));

        select.selectByIndex(2);
        webDriverWait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath("//option[@value=\"peach\"]"), true));

        System.out.println("WE'VE SELECTED ALL THE ELEMENTS IN THE MULTI COMBO BOX");
    }

    // Sephora.com Test

//    @Test
//    public void testSearch() {
//        webDriverWait = new WebDriverWait(driver, 5);
//        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#site_search_input"))));
//
//        WebElement searchInputBox = driver.findElement(By.cssSelector("#site_search_input"));
//
//        searchInputBox.sendKeys("eyeliner");
//        searchInputBox.sendKeys(Keys.ENTER);
//
//        Wait<ChromeDriver> fluentWait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(10))
//                .pollingEvery(Duration.ofSeconds(1))
//                .ignoring(StaleElementReferenceException.class);
//
//        fluentWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.css-9cc1en.e65zztl0 h1 span"))));
//        WebElement searchResults = driver.findElement(By.cssSelector("div.css-9cc1en.e65zztl0 h1 span"));
//
//        String actualText = searchResults.getText();
//        String expectedText = "141 results";
//
//        Assert.assertEquals("Search result quantity does not match", expectedText, actualText);
//    }

    // Expedia.com Test
//    @Test
//    public void testSearchFlight() {
//        webDriverWait = new WebDriverWait(driver, 20);
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("div.uitk-tabs-container ul li:nth-child(2) a"))));
//        driver.findElement(By.cssSelector("div.uitk-tabs-container ul li:nth-child(2) a")).click();
//
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#location-field-leg1-origin-menu div.uitk-field.has-floatedLabel-label.has-icon.has-no-placeholder button"))));
//        driver.findElement(By.cssSelector("#location-field-leg1-origin-menu div.uitk-field.has-floatedLabel-label.has-icon.has-no-placeholder button")).click();
//
//        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#location-field-leg1-origin"))));
//        driver.findElement(By.cssSelector("input#location-field-leg1-origin")).sendKeys("NYC");
//
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#location-field-leg1-origin-menu > div.uitk-menu-container.uitk-menu-open.uitk-menu-pos-left.uitk-menu-container-text-nowrap > ul > li:nth-child(1) > button"))));
//        driver.findElement(By.cssSelector("#location-field-leg1-origin-menu > div.uitk-menu-container.uitk-menu-open.uitk-menu-pos-left.uitk-menu-container-text-nowrap > ul > li:nth-child(1) > button")).click();
//
//        driver.findElement(By.cssSelector("#location-field-leg1-destination-menu > div.uitk-field.has-floatedLabel-label.has-icon.has-no-placeholder > button")).click();
//
//        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#location-field-leg1-destination"))));
//        driver.findElement(By.cssSelector("#location-field-leg1-destination")).sendKeys("Paris");
//
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#location-field-leg1-destination-menu > div.uitk-menu-container.uitk-menu-open.uitk-menu-pos-left.uitk-menu-container-text-nowrap > ul > li:nth-child(1) > button"))));
//        driver.findElement(By.cssSelector("#location-field-leg1-destination-menu > div.uitk-menu-container.uitk-menu-open.uitk-menu-pos-left.uitk-menu-container-text-nowrap > ul > li:nth-child(1) > button")).click();
//
//        // Click submit button
//        driver.findElement(By.xpath("//button[@data-testid=\"submit-button\"]")).click();
//
//        // New page is loading - We need to wait for first search result to be clickable
//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@data-test-id=\"listings\"]//li[@data-test-id=\"offer-listing\"][1]//button[@data-test-id='select-link']")));
//
//        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[@class=\"uitk-typelist uitk-typelist-orientation-stacked uitk-typelist-size-2 uitk-typelist-spacing\"]//li[@id=\"AQrjAgrNAnY1LXNvcy00M2ZiOTYzODQxODQwMjkxMjhiMzYyYmVhMDY3MTA1Yy0wLTAtMX4yLlN-QVFvQ0NBRVNCd2pVQkJBQkdBRW9BbGdDY0FBfkFRcFBDaVFJMWJBQkVnSTVNaGlwVVNDTUdDaTloUGdCTVBDSC1BRTRXa0FBV0FGcUJFeEpWRVVLSndqVnNBRVNCREV3TWpVWWpCZ2dyc1FCS05pSy1BRXd5NHY0QVRoYVFBRllBV29FVEVsVVJRcFBDaWNJMWJBQkVnUXhNREkyR0s3RUFTQ01HQ2lDalBnQk1QcU0tQUU0VGtBQVdBRnFCRXhKVkVVS0pBalZzQUVTQWpreEdJd1lJS2xSS0ktVi1BRXctWmo0QVRoT1FBRllBV29FVEVsVVJSSUtDQUVRQVJnQktnSlZXQmdCSWdRSUFSQUJLQUlvQXlnRU1BRRGuR-F6FIp_QCIBASoFEgMKATESPwoWCgoyMDIxLTA5LTIyEgNOWUMaA1BBUgoWCgoyMDIxLTA5LTIzEgNQQVIaA05ZQxIHEgVDT0FDSBoCEAEgAg==\"]//div[@class=\"uitk-text truncate uitk-type-200 uitk-spacing uitk-spacing-margin-blockstart-one uitk-text-emphasis-theme\"]"))));
//
//        String actualText = driver.findElement(By.xpath("//ul[@class=\"uitk-typelist uitk-typelist-orientation-stacked uitk-typelist-size-2 uitk-typelist-spacing\"]//li[@id=\"AQrjAgrNAnY1LXNvcy00M2ZiOTYzODQxODQwMjkxMjhiMzYyYmVhMDY3MTA1Yy0wLTAtMX4yLlN-QVFvQ0NBRVNCd2pVQkJBQkdBRW9BbGdDY0FBfkFRcFBDaVFJMWJBQkVnSTVNaGlwVVNDTUdDaTloUGdCTVBDSC1BRTRXa0FBV0FGcUJFeEpWRVVLSndqVnNBRVNCREV3TWpVWWpCZ2dyc1FCS05pSy1BRXd5NHY0QVRoYVFBRllBV29FVEVsVVJRcFBDaWNJMWJBQkVnUXhNREkyR0s3RUFTQ01HQ2lDalBnQk1QcU0tQUU0VGtBQVdBRnFCRXhKVkVVS0pBalZzQUVTQWpreEdJd1lJS2xSS0ktVi1BRXctWmo0QVRoT1FBRllBV29FVEVsVVJSSUtDQUVRQVJnQktnSlZXQmdCSWdRSUFSQUJLQUlvQXlnRU1BRRGuR-F6FIp_QCIBASoFEgMKATESPwoWCgoyMDIxLTA5LTIyEgNOWUMaA1BBUgoWCgoyMDIxLTA5LTIzEgNQQVIaA05ZQxIHEgVDT0FDSBoCEAEgAg==\"]//div[@class=\"uitk-text truncate uitk-type-200 uitk-spacing uitk-spacing-margin-blockstart-one uitk-text-emphasis-theme\"]")).getText();
//
//        driver.findElement(By.cssSelector("#bmwradio"));
//        String expectedText = "New York (JFK) - Paris (ORY)";
//
//        Assert.assertEquals(expectedText, actualText);
//    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}

