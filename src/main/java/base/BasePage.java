package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WaitTimers;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class BasePage {
    public WebDriver driver;
    public WaitTimers wt = new WaitTimers();

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitforElementClickable(By locator, Duration waitTimeInSecond) {
        new WebDriverWait(driver, waitTimeInSecond).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitforElementVisible(By locator) {
        new WebDriverWait(driver, wt.defaultWait).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void scrolltoElement(By locator) {
        /*Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(locator));
        a.perform();*/
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
        waitforElementVisible(locator);
    }

    public void clickElementByJS(By locator) {
        WebElement element = new WebDriverWait(driver, wt.extraWait).until(ExpectedConditions.elementToBeClickable(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public boolean clickElement(By locator) {
        try {
            WebElement elementToClick = new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.elementToBeClickable(locator));
            elementToClick.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean sendKeysToElement(By locator, String keys) {
        try {
            WebElement elementToSend = new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.elementToBeClickable(locator));
            elementToSend.sendKeys(keys);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public By replaceElement(String locator, String toReplace, String replaceBy) {
        String elementToReplace = String.valueOf(locator).replaceAll(toReplace, replaceBy);
        return By.xpath(elementToReplace);
    }

    public boolean doubleClick(By locator) {
        try {
            WebElement elementToDoubleClick = new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.elementToBeClickable(locator));
            Actions doubleClicks = new Actions(driver);
            doubleClicks.doubleClick(elementToDoubleClick).perform();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean rightClick(By locator) {
        try {
            WebElement elementToRightClick = new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.elementToBeClickable(locator));
            Actions rightClicks = new Actions(driver);
            rightClicks.contextClick(elementToRightClick).perform();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String grabText(By locator) {
        try {
            WebElement textToGrab = new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(locator));
            return textToGrab.getText();
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

    public boolean switchToPreviousTab() {
        try {
            Set<String> windows = driver.getWindowHandles();
            Iterator<String> itr = windows.iterator();
            String prev = itr.next();
            driver.switchTo().window(prev);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean switchToNextTab() {
        try {
            Set<String> windows = driver.getWindowHandles();
            Iterator<String> itr = windows.iterator();
            itr.next();
            String next = itr.next();
            driver.switchTo().window(next);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean confirmElementIsVisible(By locator) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    public void verifyURLLinks(String urlLink)
    {
        try
        {
            URL url = new URL(urlLink);
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()>=400)
            {
                System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage() + "is a broken link");
            }else{
                System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage());
            }
        }catch (Exception e) {
            System.out.println("Unable to verify HTTP STATUS");
        }
    }

}
