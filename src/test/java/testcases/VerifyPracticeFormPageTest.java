package testcases;

import org.junit.Test;
import pages.Homepage;
import pages.forms.Forms;
import pages.forms.practiceform.PracticeForm;
import pages.forms.practiceform.PracticeFormSubmitModalPage;
import setup.BaseTest;

import static org.junit.Assert.assertTrue;

public class VerifyPracticeFormPageTest extends BaseTest {

    @Test
    public void test1() {
        Homepage home = new Homepage(driver);
        home.clickOnCardForms();

        Forms forms = new Forms(driver);
        forms.clickOnFormsPracticeForm();

        PracticeForm practiceForm = new PracticeForm(driver);
        practiceForm.verifyPracticeFormPageHeader();
        practiceForm.typeFirstName("Satish");
        practiceForm.typeLastName("Renewals");
        practiceForm.typeEmail("satishtest@renewalteam.lcl");
        practiceForm.selectGender("Male");
        practiceForm.typeMobile("9876543210");
        practiceForm.setDate("8-Dec-1990");
        practiceForm.selectSubjects(new String[]{"Hindi","English","Maths"});
        practiceForm.selectHobby(new String[]{"Reading","Music"});
        practiceForm.selectPicture("C:\\Users\\smainkatte\\Downloads\\TestsampleFile.jpeg");
        practiceForm.typeCurrentAddress("Kolhapur, Maharashtra, 410000");
        practiceForm.selectState("NCR");
        practiceForm.selectCity("Delhi");
        practiceForm.clickOnSubmit();

        PracticeFormSubmitModalPage practiceFormSubmitModalPage = new PracticeFormSubmitModalPage(driver);
        assertTrue("Unable to find Submit modal Page", practiceFormSubmitModalPage.verifyPracticeFormSubmitModalPageHeader());
        practiceFormSubmitModalPage.getPracticeFormSubmitModalPageData();
        practiceFormSubmitModalPage.clickOnCloseButton();
    }
}
