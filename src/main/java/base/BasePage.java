package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WaitTimers;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WaitTimers wt = new WaitTimers();

    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    public void waitforElementClickable(By locator, Duration waitTimeInSecond){
        new WebDriverWait(driver, waitTimeInSecond).until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitforElementVisible(By locator){
        new WebDriverWait(driver, wt.defaultWait).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void scrolltoElement(By locator){
        /*Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(locator));
        a.perform();*/
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
        waitforElementVisible(locator);
    }
    public void clickElementByJS(By locator){
        WebElement element = new WebDriverWait(driver, wt.extraWait).until(ExpectedConditions.elementToBeClickable(locator));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
    }

}
