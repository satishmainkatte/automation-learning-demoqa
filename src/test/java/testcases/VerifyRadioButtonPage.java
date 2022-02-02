package testcases;

import org.junit.Test;
import pages.Homepage;
import pages.elements.Elements;
import pages.elements.radiobutton.RadioButton;
import setup.BaseTest;

public class VerifyRadioButtonPage extends BaseTest {
    @Test
    public void test1() {
        Homepage home = new Homepage(driver);
        home.clickOnCardElements();

        Elements elements = new Elements(driver);
        elements.clickOnElementRadioButton();

        RadioButton radioButton = new RadioButton(driver);
        radioButton.verifyRadioButtonPageHeader();
        radioButton.selectYesRadioButton();
        radioButton.verifySelectedRadioButtonOutput();
        radioButton.selectImpressiveRadioButton();
        radioButton.verifySelectedRadioButtonOutput();
    }
}
