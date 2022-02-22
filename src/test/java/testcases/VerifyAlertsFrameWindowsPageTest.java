package testcases;

import org.junit.Test;
import pages.AlertsFrameWindows.AlertsFrameWindows;
import pages.Homepage;
import setup.BaseTest;

import static org.junit.Assert.assertTrue;

public class VerifyAlertsFrameWindowsPageTest extends BaseTest {
    @Test
    public void test1() {
        Homepage home = new Homepage(driver);
        home.clickOnCardAlertsFrameWindows();

        AlertsFrameWindows alertsFrameWindows = new AlertsFrameWindows(driver);
        assertTrue("Incorrect page header!", alertsFrameWindows.verifyAlertsFrameWindowsPageHeader());
    }
}
