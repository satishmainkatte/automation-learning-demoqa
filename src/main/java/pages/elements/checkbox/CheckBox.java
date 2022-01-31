package pages.elements.checkbox;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBox extends BasePage {

    By checkboxHeader = By.cssSelector("div.main-header");
    By buttonExpandAll = By.xpath("//button[@title='Expand all']");
    By getButtonCollapseAll = By.xpath("//button[@title='Collapse all']");
    By verifyCheckBoxOutput = By.cssSelector("div#result span.text-success");
    String genericPath = "//input[@id='tree-node-chkbox_name']/following-sibling::span";

    public CheckBox(WebDriver driver) {
        super(driver);
    }

    public boolean verifyCheckBoxPageHeader() {
        try {
            waitforElementVisible(checkboxHeader);
            return driver.findElement(checkboxHeader).getText().equals("Check Box");
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnExpandAllButton() {
        waitforElementClickable(buttonExpandAll, wt.longWait);
        driver.findElement(buttonExpandAll).click();
    }

    public void clickOnCollapseAllButton() {
        waitforElementClickable(getButtonCollapseAll, wt.longWait);
        driver.findElement(getButtonCollapseAll).click();
    }

    public void selectCheckBox(String checkBoxToSelect) {
        clickOnExpandAllButton();
        String newpath = genericPath.replace("chkbox_name", checkBoxToSelect.toLowerCase());
        if (!driver.findElement(By.xpath(newpath)).isSelected()) {
            driver.findElement(By.xpath(newpath)).click();
            System.out.println("Checkbox is Toggled On");
        } else {
            System.out.println("Checkbox has already Toggled On");
        }
    }
    public String verifyCheckBoxOutput(){
        waitforElementVisible(verifyCheckBoxOutput);
        return driver.findElement(verifyCheckBoxOutput).getText().trim();
    }
    public boolean verifySelectedCheckbox(String checkBoxToSelect){
        try {
            selectCheckBox(checkBoxToSelect);
            return verifyCheckBoxOutput().equals(checkBoxToSelect.toLowerCase());
        }catch (Exception e){
            return false;
        }
    }
}
