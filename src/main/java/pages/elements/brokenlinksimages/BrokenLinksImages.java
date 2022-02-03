package pages.elements.brokenlinksimages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinksImages extends BasePage {

    By brokenLinksImagesHeader = By.cssSelector("div.main-header");
    By imagesPath = By.tagName("img");


    public BrokenLinksImages(WebDriver driver) {
        super(driver);
    }

    public boolean verifyBrokenLinksImagesPageHeader(){
        try{
            waitforElementVisible(brokenLinksImagesHeader);
            return driver.findElement(brokenLinksImagesHeader).getText().equals("Broken Links - Images");
        }catch (Exception e){
            return false;
        }
    }
    public boolean verifyBrokenImagesOnPage(){
        try{
            List<WebElement> images = driver.findElements(imagesPath);
            System.out.println("Total number of Images on the Page are " + images.size());

            for(int index=0;index<images.size();index++) {
                WebElement img = images.get(index);
                String imgURL = img.getAttribute("src");
                System.out.println("Image " + (index + 1) + " URL is: " + imgURL);
                verifyURLLinks(imgURL);

                try {
                    boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver).executeScript("return (typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0);", img);
                    if (imageDisplayed) {
                        System.out.println("DISPLAY - OK");
                    } else {
                        System.out.println("DISPLAY - BROKEN");
                    }
                } catch (Exception e) {
                    System.out.println("Error Occured");
                }
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
