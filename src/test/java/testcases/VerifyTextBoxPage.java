package testcases;

import org.junit.Test;
import pages.Homepage;
import pages.elements.Elements;
import pages.elements.textbox.TextBox;
import setup.BaseTest;

import static org.junit.Assert.assertTrue;

public class VerifyTextBoxPage extends BaseTest {

    @Test
    public void test1() {
        Homepage home = new Homepage(driver);
        home.clickOnCardElements();

        Elements elements = new Elements(driver);
        elements.clickOnElementTextBox();

        TextBox textBox = new TextBox(driver);
        textBox.verifyTextBoxPageHeader();
        /*textBox.typeFullName("Satish Mainkatte");
        textBox.typeEmail("smainkatte2022@test.lcl");
        textBox.typeCurrentAddress("Maharashtra, India");
        textBox.typePermanentAddress("Kolhapur, India");
        textBox.clickOnSubmitButton();*/
        assertTrue("Entered Details not matching.",textBox.verifyTextBoxPage("Satish Mainkatte", "smainkatte2022@test.lcl", "Maharashtra, India", "Kolhapur, India"));
    }
}
