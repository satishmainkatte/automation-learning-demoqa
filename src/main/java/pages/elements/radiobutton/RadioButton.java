package pages.elements.radiobutton;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButton extends BasePage {

    public RadioButton(WebDriver driver) {
        super(driver);
    }

    private final By RADIO_BUTTON = By.xpath("//span[text()='Radio Button']");
    private final String RADIO_OPTION = "//label[text()='option']";
    private final By VALIDATE_TEXT = By.xpath("//p[@class='mt-3']");

    public boolean selectOptionRadioButton() {
        if (confirmElementIsVisible(RADIO_BUTTON)){
            return clickElement(RADIO_BUTTON);
        }
        return false;
    }

    public boolean selectRadioOption(String option) {
        return clickElement(replaceElement(RADIO_OPTION, "option", option));
    }

    public boolean validateResult(String option) {
        selectRadioOption(option);
        String str = grabText(VALIDATE_TEXT);
        if (str.equals("You have selected" + " " + option)) {
            return true;
        } else return false;

    }
}
