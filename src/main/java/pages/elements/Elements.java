package pages.elements;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Elements extends BasePage {

    By elementsHeader = By.cssSelector("div.main-header");

    public Elements(WebDriver driver) {
        super(driver);
    }

    public boolean verifyElementsPageHeader(){
        try{
            waitforElementVisible(elementsHeader);
            return driver.findElement(elementsHeader).getText() == "ToolsQA";
        }catch (Exception e){
            return false;
        }
    }
}
