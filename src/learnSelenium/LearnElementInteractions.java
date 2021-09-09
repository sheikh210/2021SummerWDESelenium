package learnSelenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class LearnElementInteractions extends LearnWebDriverBasics {

    @Test
    public void testKodeItComboBox() throws Exception {
        WebElement comboBox = driver.findElement(By.id("carselect"));
        Select select = new Select(comboBox);
//        select.selectByValue("benz");
//        select.selectByVisibleText("Benz");
        select.selectByIndex(2);

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

    @Test
    public void testKodeItCheckBox() throws Exception {
        webDriverWait = new WebDriverWait(driver, 10);

        WebElement bmwCheckbox = driver.findElement(By.id("bmwcheck"));
        WebElement benzCheckbox = driver.findElement(By.id("benzcheck"));
        WebElement hondaCheckbox = driver.findElement(By.id("hondacheck"));

        bmwCheckbox.click();
        webDriverWait.until(ExpectedConditions.elementSelectionStateToBe(bmwCheckbox, true));

        Thread.sleep(1000);

        benzCheckbox.click();
        webDriverWait.until(ExpectedConditions.elementSelectionStateToBe(benzCheckbox, true));

        Thread.sleep(1000);

        hondaCheckbox.click();
        webDriverWait.until(ExpectedConditions.elementSelectionStateToBe(hondaCheckbox, true));

        Thread.sleep(1000);

        hondaCheckbox.click();
        webDriverWait.until(ExpectedConditions.elementSelectionStateToBe(hondaCheckbox, false));

        Thread.sleep(1000);

        benzCheckbox.click();
        webDriverWait.until(ExpectedConditions.elementSelectionStateToBe(benzCheckbox, false));

        Thread.sleep(1000);

        bmwCheckbox.click();
        webDriverWait.until(ExpectedConditions.elementSelectionStateToBe(bmwCheckbox, false));
    }

    @Test
    public void testKodeItNewWindow() {
        webDriverWait = new WebDriverWait(driver, 10);

        String parentWindow = driver.getWindowHandle();
        System.out.println(parentWindow);

        driver.findElement(By.id("openwindow")).click();

        webDriverWait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> windowHandles = driver.getWindowHandles();

        for(String handle : windowHandles) {
            if (!(handle.equals(parentWindow))) {
                System.out.println(handle);
                driver.switchTo().window(handle);
            }
        }

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href=\"/courses/test-automation-bundle\"]"))).click();

        String expectedURL = "https://courses.letskodeit.com/courses/test-automation-bundle";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(expectedURL, actualURL);
    }

    @Test
    public void testKodeItNewTabs() {
        webDriverWait = new WebDriverWait(driver, 10);

        String parentTab = driver.getWindowHandle();

        driver.findElement(By.id("opentab")).click();

        webDriverWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> tabHandles = driver.getWindowHandles();
        Iterator<String> iterator = tabHandles.iterator();

        while (iterator.hasNext()) {
            String childTab = iterator.next();

            if (!(childTab.equalsIgnoreCase(parentTab))) {
                driver.switchTo().window(childTab);
                break;
            }
        }

        webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@href=\"/courses/selenium-webdriver-advanced\"]")))).click();
        webDriverWait.until(ExpectedConditions.urlToBe("https://courses.letskodeit.com/courses/selenium-webdriver-advanced"));

        driver.switchTo().window(parentTab);

        String actualText = driver.findElement(By.xpath("//*[@id=\"open-tab-example-div\"]/fieldset/legend")).getText();
        String expectedText = "Switch Tab Example";

        Assert.assertEquals(expectedText, actualText);
    }

}
