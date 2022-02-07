package testcases;

import org.junit.Test;
import pages.Homepage;
import pages.elements.Elements;
import pages.elements.uploadanddownload.Uploadanddownload;
import setup.BaseTest;

import static org.junit.Assert.assertTrue;

public class VerifyUploadAndDownloadPageTest extends BaseTest {

    @Test
    public void uploadAndDownload() {
        Homepage home = new Homepage(driver);
        home.clickOnCardElements();

        Elements elements = new Elements(driver);
        elements.clickOnUploadAndDownload();

        Uploadanddownload upl = new Uploadanddownload(driver);
        assertTrue("Unable to select element upload and download option", upl.selectUploadAndDownload());
        assertTrue("Unable to see Upload and Download text", upl.verifyUploadAndDownloadPageHeader());
        assertTrue("Unable to select download option", upl.downloadClickButton());
        assertTrue("Unable to select download option", upl.uploadFile());



    }
}
