package testcases;

import org.junit.Test;
import pages.Homepage;
import pages.elements.Elements;
import pages.elements.checkbox.CheckBox;
import setup.BaseTest;

public class VerifyCheckBoxPage extends BaseTest {
    @Test
    public void test1() {
        Homepage home = new Homepage(driver);
        home.clickOnCardElements();

        Elements elements = new Elements(driver);
        elements.clickOnElementCheckBox();

        CheckBox checkBox = new CheckBox(driver);
        checkBox.verifyCheckBoxPageHeader();
        //checkBox.selectCheckBox("Notes");
        checkBox.verifySelectedCheckbox("Private");
    }
}
