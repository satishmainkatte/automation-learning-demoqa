package pages.forms;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Forms extends BasePage {

    private final By formsHeader = By.cssSelector("div.main-header");
    private final By formsPracticeForm = By.xpath("//span[contains(text(),'Practice Form')]");

    public Forms(WebDriver driver) {
        super(driver);
    }

    public boolean verifyFormsPageHeader(){
        try{
            waitforElementVisible(formsHeader);
            String str = driver.findElement(formsHeader).getText();
            return driver.findElement(formsHeader).getText().equals("Forms");
        }catch (Exception e){
            return false;
        }
    }
    public void clickOnFormsPracticeForm(){
        waitforElementClickable(formsPracticeForm, wt.longWait);
        driver.findElement(formsPracticeForm).click();
    }
}
