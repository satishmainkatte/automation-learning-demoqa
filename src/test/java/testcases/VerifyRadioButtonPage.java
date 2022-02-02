package testcases;

import org.junit.Test;
import pages.Homepage;
import pages.elements.Elements;
import pages.elements.radiobutton.RadioButton;
import setup.BaseTest;

import static org.junit.Assert.assertTrue;

public class VerifyRadioButtonPage extends BaseTest {
    @Test
    public void test1() {
        Homepage home = new Homepage(driver);
        home.clickOnCardElements();

        Elements elements = new Elements(driver);
        elements.clickOnElementRadioButton();

        RadioButton radioButton = new RadioButton(driver);
        assertTrue("Unable to click Radio Option", radioButton.selectOptionRadioButton());
        assertTrue("Unable to click Radio Option", radioButton.validateResult("Impressive"));
    }
}
