package testcases;

import org.junit.Test;
import pages.AlertsFrameWindows.AlertsFrameWindows;
import pages.AlertsFrameWindows.BrowserWindows.BrowserWindows;
import pages.Homepage;
import setup.BaseTest;

import static org.junit.Assert.assertTrue;

public class VerifyBrowserWindowsPageTest extends BaseTest {
    @Test
    public void test1() {
        Homepage home = new Homepage(driver);
        home.clickOnCardAlertsFrameWindows();

        AlertsFrameWindows alertsFrameWindows = new AlertsFrameWindows(driver);
        alertsFrameWindows.clickOnElementBrowserWindowButton();

        BrowserWindows browserWindows = new BrowserWindows(driver);
        browserWindows.verifyBrowserWindowsPageHeader();
        browserWindows.clickOnTabButton();
        assertTrue("New tab Header is incorrect!", browserWindows.verifyNewTabHeader("This is a sample page"));
        browserWindows.clickOnWindowButton();
        assertTrue("New Browser window header is incorrect!", browserWindows.verifyNewWindowHeader("This is a sample page"));
        browserWindows.clickOnNewWindowMessageButton();
        assertTrue("New Window Message Text is incorrect!", browserWindows.verifyNewWindowMessageText());
    }
}
