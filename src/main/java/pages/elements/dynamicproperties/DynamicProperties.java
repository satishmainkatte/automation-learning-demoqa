package pages.elements.dynamicproperties;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import static java.lang.Thread.*;
import static java.lang.Thread.sleep;

public class DynamicProperties extends BasePage {
    By dynamicpropertiesheader = By.cssSelector("div.main-header");
    private final By Enable5sec = By.xpath("//button[@id='enableAfter']");
    private final By ChangeColor = By.xpath("//button[@id='colorChange']");
    private final By VisibleAfter = By.xpath("//button[@id='visibleAfter']");

    public DynamicProperties(WebDriver driver) {
        super(driver);
    }

    public String verifyDynamicpropertiesheader() {

        String text = driver.findElement(By.xpath("//div[@class='main-header']")).getText();
        return text;
    }


    public void verifyAttributeValue() {

        try {

            String text1 = driver.findElement(By.xpath("//button[@id='colorChange']")).getAttribute("class");

            System.out.println("attribute  value" + text1);
            sleep(5000);
        } catch (Exception e) {
            String text5sec = driver.findElement(By.xpath("//button[@id='colorChange']")).getAttribute("class");
            System.out.println("ttribute value" + text5sec);
        }
    }
}
















   

