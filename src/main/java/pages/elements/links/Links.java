package pages.elements.links;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Links extends BasePage {
    public Links(WebDriver driver) {
        super(driver);
    }
    private final By LINK_NAME = By.linkText("Home");
    private final By LINKS = By.xpath("//span[text()='Links']");

    public boolean checkLink(){
        if (confirmElementIsVisible(LINK_NAME)){
            clickElement(LINK_NAME);
            switchToNextTab();
            String  str = driver.getCurrentUrl();
            if (str.equals("https://demoqa.com/")){
                return true;
            }
        }
        return false;
    }

    public boolean selectOptionLinks(){
        if (confirmElementIsVisible(LINKS)){
            return clickElement(LINKS);
        }
        return false;
    }
}
