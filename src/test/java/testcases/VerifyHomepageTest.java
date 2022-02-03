package testcases;

import org.junit.Test;
import pages.Homepage;
import setup.BaseTest;

public class VerifyHomepageTest extends BaseTest {

    @Test
    public void test1() {
        Homepage home = new Homepage(driver);
        home.verifyHomepageTitle();
        home.clickOnCardElements();
        home.clickOnHomeLink();
        home.clickOnCardForms();
        home.clickOnHomeLink();
        home.clickOnCardAlertsFrameWindows();
        home.clickOnHomeLink();
        home.clickOnCardWidgets();
        home.clickOnHomeLink();
        home.clickOnCardInteractions();
        home.clickOnHomeLink();
        home.clickOnCardBookStoreApplication();
        home.clickOnHomeLink();
    }
}
