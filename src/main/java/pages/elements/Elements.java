package pages.elements;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Elements extends BasePage {

    By elementsHeader = By.cssSelector("div.main-header");
    By elementTextBox = By.xpath("//span[contains(text(),'Text Box')]");
    By elementCheckBox = By.xpath("//span[contains(text(),'Check Box')]");


    public Elements(WebDriver driver) {
        super(driver);
    }

    public boolean verifyElementsPageHeader(){
        try{
            waitforElementVisible(elementsHeader);
            String str = driver.findElement(elementsHeader).getText();
            return driver.findElement(elementsHeader).getText().equals("Elements");
        }catch (Exception e){
            return false;
        }
    }

    public void clickOnElementTextBox(){
        waitforElementClickable(elementTextBox,wt.longWait);
        driver.findElement(elementTextBox).click();
    }
    public void clickOnElementCheckBox(){
        waitforElementClickable(elementCheckBox,wt.longWait);
        driver.findElement(elementCheckBox).click();
    }
}
