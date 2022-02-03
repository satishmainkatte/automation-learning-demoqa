package testcases;

import org.junit.Test;
import pages.Homepage;
import pages.elements.Elements;
import pages.elements.buttons.Buttons;
import setup.BaseTest;

import static org.junit.Assert.assertTrue;

public class VerifyButtonsPageTest extends BaseTest {

    @Test
    public void buttons() {
        Homepage home = new Homepage(driver);
        home.clickOnCardElements();

        Elements elements = new Elements(driver);
        elements.clickOnElementButton();

        Buttons but = new Buttons(driver);
        assertTrue("Unable to select Buttons option", but.selectOptionButtons());
        assertTrue("Unable to double click", but.doubleClickButton());
        assertTrue("Unable to right click", but.rightClickButton());
    }
}
