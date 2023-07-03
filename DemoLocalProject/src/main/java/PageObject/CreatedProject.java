package PageObject;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.actions.JsActions;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

import static aquality.selenium.browser.AqualityServices.getElementFactory;

public class CreatedProject {
    Browser browser = AqualityServices.getBrowser();
    private String TestStatus;
    private final IButton createdProject = getElementFactory().getButton(By.xpath("//a[normalize-space()='Euronews']"), "Created Project");
    private final IButton addTest = getElementFactory().getButton(By.xpath("//button[contains(@data-target,'#addTest')]"), "Add Test");
    private final ITextBox testName = getElementFactory().getTextBox(By.xpath("//input[contains(@id,'testName')]"), "Test Name");
    private final List<ITextBox> testStatus = getElementFactory().findElements(By.xpath("//select[contains(@name,'status')]//option"), "Test Status Selected", ElementType.TEXTBOX);
    private final ITextBox jsTestStatus = getElementFactory().getTextBox(By.xpath("//select[contains(@name,'status')]"), "Test Status Selected");
    private final ITextBox testMethod = getElementFactory().getTextBox(By.xpath("//input[contains(@id,'testMethod')]"), "Test Method");
    private final ITextBox startTime = getElementFactory().getTextBox(By.xpath("//input[contains(@did,'startTime')]"), "Start Time");
    private final ITextBox endTime = getElementFactory().getTextBox(By.xpath("//input[contains(@id,'endTime')]"), "End Time");
    private final ITextBox testEnv = getElementFactory().getTextBox(By.xpath("//input[contains(@id,'environment')]"), "Environment");
    private final ITextBox browserName = getElementFactory().getTextBox(By.xpath("//input[contains(@id,'browser')]"), "Browser");
    private final IButton chooseFile = getElementFactory().getButton(By.xpath("//input[@id='attachment']"), "Choose File");
    private final IButton saveTest = getElementFactory().getButton(By.xpath("//button[normalize-space()='Save Test']"), "Save Test");
    private final ITextBox alertText = getElementFactory().getTextBox(By.xpath("//div[contains(@id,'success')]"), "Test Saved");
    public void clickCreatedProject(){
        createdProject.clickAndWait();
    }
    public void clickAddTest(){
        addTest.click();
    }
    public void setTestName(String name){
        testName.type(name);
    }
    JsActions js=new JsActions(jsTestStatus,"Selected");
    public void scrollStatusInDropdown(){
        js.scrollIntoView();
    }
    public String statusClick(){
        for (int i=0;i<testStatus.size();i++) {
            Random r= new Random();
            int randomValue = r.nextInt(testStatus.size());
            testStatus.get(randomValue).click();
            TestStatus=testStatus.get(randomValue).toString();
        }
        return TestStatus;
    }
    public void setTestMethod(String method){
        testMethod.type(method);
    }
    public void setStartTime(String stime){
        startTime.type(stime);
    }
    public void setEndTime(String etime){
        endTime.type(etime);
    }
    public void setTestEnv(String env){
        testEnv.type(env);
    }
    public void setBrowser(String browser){
        browserName.type(browser);
    }
    public void setSaveTest(){
        saveTest.clickAndWait();
    }
    public String getAlertText(){
        String text=alertText.getText();
        return text;
    }

}
