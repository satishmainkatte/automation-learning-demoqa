package pages.elements.textbox;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBox extends BasePage {

    By textboxHeader = By.cssSelector("div.main-header");
    By textboxFullName = By.cssSelector("input#userName");
    By textboxEmail = By.cssSelector("input#userEmail");
    By textboxCurrentAddress = By.cssSelector("textarea#currentAddress");
    By textboxPermanentAddress = By.cssSelector("textarea#permanentAddress");
    By buttonSubmit = By.cssSelector("button#submit");
    By outputFullName = By.cssSelector("div#output p#name");
    By outputEmail = By.cssSelector("div#output p#email");
    By outputCurrentAddress = By.cssSelector("div#output p#currentAddress");
    By outputPermanentAddress = By.cssSelector("div#output p#permanentAddress");


    public TextBox(WebDriver driver) {
        super(driver);
    }

    public boolean verifyTextBoxPageHeader(){
        try{
            waitforElementVisible(textboxHeader);
            return driver.findElement(textboxHeader).getText().equals("Text Box");
        }catch (Exception e){
            return false;
        }
    }
    public void typeFullName(String fullName){
        waitforElementVisible(textboxFullName);
        driver.findElement(textboxFullName).sendKeys(fullName);
    }
    public void typeEmail(String email){
        waitforElementVisible(textboxEmail);
        driver.findElement(textboxEmail).sendKeys(email);
    }
    public void typeCurrentAddress(String currentAddress){
        waitforElementVisible(textboxCurrentAddress);
        driver.findElement(textboxCurrentAddress).sendKeys(currentAddress);
    }
    public void typePermanentAddress(String permanentAddress){
        waitforElementVisible(textboxPermanentAddress);
        driver.findElement(textboxPermanentAddress).sendKeys(permanentAddress);
    }
    public boolean clickOnSubmitButton(){
        try {
            waitforElementClickable(buttonSubmit,wt.longWait);
            driver.findElement(buttonSubmit).click();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public String outputFullName(String fullName){
        waitforElementVisible(outputFullName);
        String s=driver.findElement(outputFullName).getText();
        return s.substring(s.indexOf(':')+1).trim();
    }
    public String outputEmail(String email){
        waitforElementVisible(outputEmail);
        String s=driver.findElement(outputEmail).getText();
        return s.substring(s.indexOf(':')+1).trim();
    }
    public String outputCurrentAddress(String currentAddress){
        waitforElementVisible(outputCurrentAddress);
        String s=driver.findElement(outputCurrentAddress).getText();
        return s.substring(s.indexOf(':')+1).trim();
    }
    public String outputPermanentAddress(String permanentAddress){
        waitforElementVisible(outputPermanentAddress);
        String s=driver.findElement(outputPermanentAddress).getText();
        return s.substring(s.indexOf(':')+1).trim();
    }
    public boolean verifyTextBoxPage(String fullName, String email, String currentAddress, String permanentAddress){
        try {
            typeFullName(fullName);
            typeEmail(email);
            typeCurrentAddress(currentAddress);
            typePermanentAddress(permanentAddress);
            clickOnSubmitButton();
            if (outputFullName(fullName).equals(fullName) && outputEmail(email).equals(email) && outputCurrentAddress(currentAddress).equals(currentAddress) && outputPermanentAddress(permanentAddress).equals(permanentAddress)) {
                return true;
            } else {
                return false;
            }
        }catch(Exception e){
            return false;
        }
    }
}
