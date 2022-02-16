package pages.elements.uploadanddownload;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Uploadanddownload extends BasePage {

    private final By UploadAndDownload = By.xpath("//span[contains(text(),'Upload and Download')]");
    private By UploadAndDownloadHeader = By.cssSelector("div.main-header");
    private final By Download_Button = By.id("downloadButton");
    private final By Upload_Button = By.id("uploadFile");

    public Uploadanddownload(WebDriver driver) {
        super(driver);
    }

    public boolean selectUploadAndDownload() {
        if (confirmElementIsVisible(UploadAndDownload)) {
            return clickElement(UploadAndDownload);
        }
        return false;
    }

    public boolean verifyUploadAndDownloadPageHeader() {
        try {
            waitforElementVisible(UploadAndDownloadHeader);
            return driver.findElement(UploadAndDownloadHeader).getText().equals("Upload and Download");
        } catch (Exception e) {
            return false;
        }
    }
    public boolean downloadClickButton() {
        return doubleClick(Download_Button);
    }
    public boolean uploadFile (){
        try {
            WebElement uploadElement = driver.findElement(Upload_Button);
            uploadElement.sendKeys("D:\\PhotosProject\\sampleFile.jpeg");
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
