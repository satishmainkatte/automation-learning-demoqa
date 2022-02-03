package testcases;

import org.junit.Test;
import pages.Homepage;
import pages.elements.Elements;
import pages.elements.brokenlinksimages.BrokenLinksImages;
import setup.BaseTest;

import static org.junit.Assert.assertTrue;

public class VerifyBrokenLinksImagesPage extends BaseTest {
    @Test
    public void test1() {
        Homepage home = new Homepage(driver);
        home.clickOnCardElements();

        Elements elements = new Elements(driver);
        elements.clickOnElementBrokenLinksImages();

        BrokenLinksImages brokenLinksImages = new BrokenLinksImages(driver);
        brokenLinksImages.verifyBrokenLinksImagesPageHeader();
        assertTrue("Failed to verify broken images.",brokenLinksImages.verifyBrokenImagesOnPage());


    }
}
