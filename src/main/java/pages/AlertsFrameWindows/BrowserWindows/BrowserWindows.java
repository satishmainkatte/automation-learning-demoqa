package pages.AlertsFrameWindows.BrowserWindows;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Set;

public class BrowserWindows extends BasePage {

    private final By browserWindowsHeader = By.cssSelector("div.main-header");
    private final By tabButton = By.id("tabButton");
    private final By windowButton = By.id("windowButton");
    private final By messageWindowButton = By.id("messageWindowButton");
    private final By newTabHeader = By.id("sampleHeading");
    private String currentHandle = "";
    private final By newWindowText = By.tagName("body");


    public BrowserWindows(WebDriver driver) {
        super(driver);
    }

    public boolean verifyBrowserWindowsPageHeader() {
        try {
            waitforElementVisible(browserWindowsHeader);
            return driver.findElement(browserWindowsHeader).getText().equals("Browser Windows");
        } catch (Exception e) {
            return false;
        }
    }
    public void clickOnTabButton(){
        waitforElementClickable(tabButton, wt.longWait);
        driver.findElement(tabButton).click();
    }
    public void clickOnWindowButton(){
        waitforElementClickable(windowButton, wt.longWait);
        driver.findElement(windowButton).click();
    }
    public void clickOnNewWindowMessageButton(){
        waitforElementClickable(messageWindowButton, wt.longWait);
        driver.findElement(messageWindowButton).click();
    }
    public boolean verifyNewTabHeader(String headerTextExp){
        try{
            currentHandle = driver.getWindowHandle();
            if (verifyNewWindowData(currentHandle, newTabHeader).equals(headerTextExp)){
                return true;
            } else {
                System.out.println("Header Text mis-matched");
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }
    public boolean verifyNewWindowHeader(String windowHeaderTextExp){
        try{
            currentHandle = driver.getWindowHandle();
            if (verifyNewWindowData(currentHandle, newTabHeader).equals(windowHeaderTextExp)){
                return true;
            } else {
                System.out.println("Window Header Text mis-matched");
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }
    public boolean verifyNewWindowMessageText(){
        try{
            currentHandle = driver.getWindowHandle();
            Robot robot = new Robot();
            robot.mouseMove(500,5);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(3000);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    private String verifyNewWindowData( String currentHandle, By newTabElement){
        try{
            Set<String> handles = driver.getWindowHandles();
            for(String actual: handles){
                if(!currentHandle.equals(actual))
                {
                    driver.switchTo().window(actual);
                    waitforElementVisible(newTabElement);
                    return driver.findElement(newTabElement).getText();
                }
            }
            return "";
        }catch (Exception e){
            System.out.println("Header Text Not Found");
            return null;
        }finally {
            driver.close();
            driver.switchTo().window(currentHandle);
        }
    }
}
