package pages.elements;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Elements extends BasePage {

    By elementsHeader = By.cssSelector("div.main-header");
    By elementTextBox = By.xpath("//span[contains(text(),'Text Box')]");
    By elementCheckBox = By.xpath("//span[contains(text(),'Check Box')]");
    By elementRadioButton = By.xpath("//span[contains(text(),'Radio Button')]");
    By elementButton = By.xpath("//span[text()='Buttons']");
    By elementLinkButton = By.xpath("//span[text()='Links']");
    By elementBrokenLinksImages = By.xpath("//span[contains(text(),'Broken Links - Images')]");
    By elementDynamicProperties = By.xpath("//span[contains(text(),'Dynamic Properties')]");


    public Elements(WebDriver driver) {
        super(driver);
    }

    public boolean verifyElementsPageHeader() {
        try {
            waitforElementVisible(elementsHeader);
            String str = driver.findElement(elementsHeader).getText();
            return driver.findElement(elementsHeader).getText().equals("Elements");
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnElementTextBox() {
        waitforElementClickable(elementTextBox, wt.longWait);
        driver.findElement(elementTextBox).click();
    }

    public void clickOnElementCheckBox() {
        waitforElementClickable(elementCheckBox, wt.longWait);
        driver.findElement(elementCheckBox).click();
    }

    public void clickOnElementRadioButton() {
        waitforElementClickable(elementRadioButton, wt.longWait);
        driver.findElement(elementRadioButton).click();
    }

    public void clickOnElementButton() {
        waitforElementClickable(elementButton, wt.longWait);
        driver.findElement(elementButton).click();
    }

    public void clickOnElementLink() {
        waitforElementClickable(elementLinkButton, wt.longWait);
        driver.findElement(elementLinkButton).click();
    }

    public void clickOnElementBrokenLinksImages() {
        waitforElementClickable(elementBrokenLinksImages, wt.longWait);
        driver.findElement(elementBrokenLinksImages).click();
    }
    public void ClickonElementsDynamicProperties(){
        scrolltoElement(elementDynamicProperties);
        waitforElementClickable(elementDynamicProperties, wt.longWait);
        driver.findElement(elementDynamicProperties).click();
    }
}


