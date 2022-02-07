package testcases;

import org.junit.Test;
import pages.Homepage;
import pages.forms.Forms;
import setup.BaseTest;

public class VerifyFormsPageTest extends BaseTest {

    @Test
    public void test1() {
        Homepage home = new Homepage(driver);
        home.clickOnCardForms();

        Forms forms = new Forms(driver);
        forms.verifyFormsPageHeader();
    }
}
