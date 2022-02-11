package pages.forms.practiceform;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class PracticeFormSubmitModalPage extends BasePage {

    private final By practiceFormSubmitModalHeader = By.id("example-modal-sizes-title-lg");
    private final By practiceFormSubmitModalCloseButton = By.id("closeLargeModal");
    private final By practiceFormSubmitModalGridRows = By.xpath("//table/tbody/tr");
    String practiceFormSubmitModalGridColumnLabel = "//table/tbody/tr[row_num]/td[1]";
    String practiceFormSubmitModalGridColumnValues = "//table/tbody/tr[row_num]/td[2]";

    public PracticeFormSubmitModalPage(WebDriver driver) {
        super(driver);
    }
    public boolean verifyPracticeFormSubmitModalPageHeader(){
        try{
            waitforElementVisible(practiceFormSubmitModalHeader);
            String str = driver.findElement(practiceFormSubmitModalHeader).getText();
            return driver.findElement(practiceFormSubmitModalHeader).getText().equals("Thanks for submitting the form");
        }catch (Exception e){
            return false;
        }
    }
    public void clickOnCloseButton(){
        waitforElementVisible(practiceFormSubmitModalCloseButton);
        driver.findElement(practiceFormSubmitModalCloseButton).click();
    }
    public void getPracticeFormSubmitModalPageData(){
        int rows = driver.findElements(practiceFormSubmitModalGridRows).size();
        String[] labels = new String[rows];
        String[] values = new String[rows];
        for(int i=0; i< rows; i++){
            String num = Integer.toString(i+1);
            String label = practiceFormSubmitModalGridColumnLabel.replace("row_num", num);
            labels[i] = driver.findElement(By.xpath(label)).getText();
            String value = practiceFormSubmitModalGridColumnValues.replace("row_num", num);
            values[i] = driver.findElement(By.xpath(value)).getText();
        }
        for(int i=0; i< rows; i++){
                System.out.println(labels[i]+ " :: "+ values[i]);
        }
    }
}
