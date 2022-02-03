package testcases;

import org.junit.Test;
import pages.Homepage;
import pages.elements.Elements;
import pages.elements.links.Links;
import setup.BaseTest;

import static org.junit.Assert.assertTrue;

public class VerifyLinksPageTest extends BaseTest {
    @Test
    public void links() throws InterruptedException {
        Homepage home = new Homepage(driver);
        home.clickOnCardElements();

        Elements elements = new Elements(driver);
        elements.clickOnElementLink();

        Links lkn = new Links(driver);
        assertTrue("Unable to click on Option Links", lkn.selectOptionLinks());
        assertTrue("Unable to click on link", lkn.checkLink());
        assertTrue("Unable to click on prev tab",lkn.selectPreviousTab());
        String[] str = {"Moved","Created"};
        lkn.selectApiLinks(str);


    }
}
