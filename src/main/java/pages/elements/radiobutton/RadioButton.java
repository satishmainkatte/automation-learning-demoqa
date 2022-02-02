package pages.elements.radiobutton;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButton extends BasePage {

    By radiobuttonHeader = By.cssSelector("div.main-header");
    By yesRadioButton = By.xpath("*//input[@type='radio' and@id='yesRadio']");
    By noRadioButton = By.id("noRadio");
    By impressiveRadioButton = By.id("impressiveRadio");
    By selectedRadioOutput = By.cssSelector("span.text-success");

    public RadioButton(WebDriver driver) {
        super(driver);
    }

    public boolean verifyRadioButtonPageHeader(){
        try{
            waitforElementVisible(radiobuttonHeader);
            return driver.findElement(radiobuttonHeader).getText().equals("Radio Button");
        }catch (Exception e){
            return false;
        }
    }
    public void selectYesRadioButton(){
        try {
            driver.findElement(yesRadioButton).isDisplayed();
            if(!driver.findElement(yesRadioButton).isSelected()) {
                clickElementByJS(yesRadioButton);
            }
        }catch (Exception e){
            throw e;
        }
    }
    public void selectImpressiveRadioButton(){
        waitforElementClickable(impressiveRadioButton, wt.longWait);
        driver.findElement(impressiveRadioButton).click();
    }
    public String verifySelectedRadioButtonOutput(){
        waitforElementClickable(selectedRadioOutput, wt.longWait);
        return driver.findElement(selectedRadioOutput).getText().trim();
    }
    public boolean verifySelectedCheckbox(By locator){
        try {
            return verifySelectedRadioButtonOutput().equals("Yes") || verifySelectedRadioButtonOutput().equals("Impressive");
        }catch (Exception e){
            return false;
        }
    }
}
