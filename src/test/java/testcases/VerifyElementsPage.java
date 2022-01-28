package testcases;

import org.junit.Test;
import pages.Homepage;
import pages.elements.Elements;
import setup.BaseTest;

public class VerifyElementsPage extends BaseTest {
    @Test
    public void test1() {
        Homepage home = new Homepage(driver);
        home.clickOnCardElements();

        Elements elements = new Elements(driver);
        elements.verifyElementsPageHeader();
        elements.clickOnElementTextBox();
    }
}
