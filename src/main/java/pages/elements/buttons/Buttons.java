package pages.elements.buttons;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Buttons extends BasePage {
    public Buttons(WebDriver driver) {
        super(driver);
    }
    private final By BUTTONS = By.xpath("//span[text()='Buttons']");
    private final By DOUBLE_BUTTON = By.id("doubleClickBtn");
    private final By RIGHT_CLICK = By.id("rightClickBtn");


    public boolean selectOptionButtons() {
        if (confirmElementIsVisible(BUTTONS)) {
            return clickElement(BUTTONS);
        }
        return false;
    }

    public boolean doubleClickButton() {
        return doubleClick(DOUBLE_BUTTON);
    }

    public boolean rightClickButton() {
        return rightClick(RIGHT_CLICK);
    }
}
