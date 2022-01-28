package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage extends BasePage {

    By homeLink = By.xpath("//a[@href='https://demoqa.com']");
    By cardElements = By.xpath("//h5[contains(text(), 'Elements')]");
    By cardForms = By.xpath("//h5[contains(text(), 'Forms')]");
    By cardAlertsFrameWindows = By.xpath("//h5[contains(text(), 'Alerts, Frame & Windows')]");
    By cardWidgets = By.xpath("//h5[contains(text(), 'Widgets')]");
    By cardInteractions = By.xpath("//h5[contains(text(), 'Interactions')]");
    By cardBookStoreApplication = By.xpath("//h5[contains(text(), 'Book Store Application')]");

    public Homepage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyHomepageTitle(){
        try{
            waitforElementVisible(homeLink);
            return driver.getTitle() == "ToolsQA";
        }catch (Exception e){
            return false;
        }
    }

    public void clickOnHomeLink(){
        waitforElementClickable(homeLink,wt.longWait);
        driver.findElement(homeLink).click();
    }

    public void clickOnCardElements(){
        waitforElementClickable(cardElements,wt.longWait);
        driver.findElement(cardElements).click();
    }
    public void clickOnCardForms(){
        waitforElementClickable(cardForms,wt.longWait);
        driver.findElement(cardForms).click();
    }
    public void clickOnCardAlertsFrameWindows(){
        waitforElementClickable(cardAlertsFrameWindows,wt.longWait);
        driver.findElement(cardAlertsFrameWindows).click();
    }
    public void clickOnCardWidgets(){
        waitforElementClickable(cardWidgets,wt.longWait);
        driver.findElement(cardWidgets).click();
    }
    public void clickOnCardInteractions(){
        waitforElementClickable(cardInteractions,wt.longWait);
        driver.findElement(cardInteractions).click();
    }
    public void clickOnCardBookStoreApplication(){
        scrolltoElement(cardBookStoreApplication);
        driver.findElement(cardBookStoreApplication).click();
    }
}
