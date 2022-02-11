package pages.forms.practiceform;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class PracticeForm extends BasePage {

    private final By practiceFormHeader = By.cssSelector("div.main-header");
    private final By practiceFormFirstName = By.id("firstName");
    private final By practiceFormLastName = By.id("lastName");
    private final By practiceFormEmail = By.id("userEmail");
    private final String practiceFormGender = "//label[contains(text(),'gender')]";
    private final By practiceFormMobile = By.id("userNumber");
    private final String practiceFormDOB = "dateOfBirthInput";
    private final By practiceFormSubjects = By.xpath("//*[@id='subjectsInput']");
    private final By practiceFormAutoCompleteInput = By.xpath("//*[@id='subjectsContainer']//div[starts-with(@class,'subjects-auto-complete__menu')]");
    private final String practiceFormHobbies = "//label[contains(text(),'hobbies')]";
    private final By practiceFormPicture = By.id("uploadPicture");
    private final By practiceFormCurrentAddress = By.id("currentAddress");
    private final By practiceFormState = By.id("react-select-3-input");
    private final By practiceFormCity = By.id("react-select-4-input");
    private final By practiceFormSubmitButton = By.id("submit");
    private Actions actions = new Actions(driver);


    public PracticeForm(WebDriver driver) {
        super(driver);
    }

    public boolean verifyPracticeFormPageHeader(){
        try{
            waitforElementVisible(practiceFormHeader);
            String str = driver.findElement(practiceFormHeader).getText();
            return driver.findElement(practiceFormHeader).getText().equals("Practice Form");
        }catch (Exception e){
            return false;
        }
    }
    public void typeFirstName(String firstName){
        waitforElementVisible(practiceFormFirstName);
        driver.findElement(practiceFormFirstName).sendKeys(firstName);
    }
    public void typeLastName(String lastName){
        waitforElementVisible(practiceFormLastName);
        driver.findElement(practiceFormLastName).sendKeys(lastName);
    }
    public void typeEmail(String email){
        waitforElementVisible(practiceFormEmail);
        driver.findElement(practiceFormEmail).sendKeys(email);
    }
    public void selectGender(String gender){
        waitforElementVisible(replaceElement(practiceFormGender, "gender", gender));
        driver.findElement(replaceElement(practiceFormGender, "gender", gender)).click();
    }
    public void typeMobile(String mobile){
        waitforElementVisible(practiceFormMobile);
        driver.findElement(practiceFormMobile).sendKeys(mobile);
    }
    public void setDate(String date){
        ((JavascriptExecutor)driver).executeScript ("document.getElementById('"+practiceFormDOB+"').removeAttribute('readonly',0);");
        ((JavascriptExecutor)driver).executeScript ("document.getElementById('"+practiceFormDOB+"').value = '';");
        ((JavascriptExecutor)driver).executeScript ("document.getElementById('"+practiceFormDOB+"').value = '"+date+"';");
    }
    public void selectSubjects(String[] subjects){
        waitforElementVisible(practiceFormSubjects);
        for(String sub:subjects){
            driver.findElement(practiceFormSubjects).sendKeys(sub);
            waitforElementVisible(practiceFormAutoCompleteInput);
            driver.findElement(practiceFormAutoCompleteInput).click();
        }
    }
    public void selectHobby(String[] hobbies){
        for(String hobby:hobbies){
            waitforElementVisible(replaceElement(practiceFormHobbies, "hobbies", hobby));
            driver.findElement(replaceElement(practiceFormHobbies, "hobbies", hobby)).click();
        }
    }
    public void selectPicture(String path){
        waitforElementVisible(practiceFormPicture);
        driver.findElement(practiceFormPicture).sendKeys(path);
    }
    public void typeCurrentAddress(String currentAddress){
        waitforElementVisible(practiceFormCurrentAddress);
        driver.findElement(practiceFormCurrentAddress).sendKeys(currentAddress);
    }
    public void selectState(String state){
        scrolltoElement(practiceFormState);
        driver.findElement(practiceFormState).sendKeys(state);
        actions.moveToElement(driver.findElement(practiceFormState)).sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
    }
    public void selectCity(String city){
        scrolltoElement(practiceFormCity);
        driver.findElement(practiceFormCity).sendKeys(city);
        actions.moveToElement(driver.findElement(practiceFormCity)).sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
    }
    public void clickOnSubmit(){
        scrolltoElement(practiceFormSubmitButton);
        driver.findElement(practiceFormSubmitButton).click();
    }
}
