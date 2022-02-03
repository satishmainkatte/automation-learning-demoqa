package pages.elements.links;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

public class Links extends BasePage {
    public Links(WebDriver driver) {
        super(driver);
    }

    private final By LINK_NAME = By.linkText("Home");
    private final By LINKS = By.xpath("//span[text()='Links']");
    private String API_LINKS = "//a[text()='Api_link']";
    private final By RESULT = By.xpath("//p[text()='Link has responded with staus ']");

    public boolean checkLink() {
        if (confirmElementIsVisible(LINK_NAME)) {
            clickElement(LINK_NAME);
            switchToNextTab();
            String str = driver.getCurrentUrl();
            if (str.equals("https://demoqa.com/")) {
                return true;
            }
            switchToPreviousTab();
        }
        return false;
    }

    public boolean selectOptionLinks() {
        if (confirmElementIsVisible(LINKS)) {
            return clickElement(LINKS);
        }
        return false;
    }

    public void selectApiLinks(String[] str) {
        for (int i = 0; i < str.length; ) {
            if (String.valueOf(str[i]).equals("Created")) {
                clickElement(replaceElement(API_LINKS, "Api_link", String.valueOf(str[i])));
                String st1 = grabText(RESULT);
                if (st1.equals("Link has responded with staus 201 and status text Created")) {
                    i++;
                }
            } else if (String.valueOf(str[i]).equals("Moved")) {
                clickElement(replaceElement(API_LINKS, "Api_link", String.valueOf(str[i])));
                String st2 = grabText(RESULT);
                if (st2.equals("Link has responded with staus 301 and status text Moved Permanently")) {
                    i++;
                }
            }
        }

    }

    public boolean selectPreviousTab() {
        switchToPreviousTab();
        return true;
    }
}
