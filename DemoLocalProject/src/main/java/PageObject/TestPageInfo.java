package PageObject;

import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.elements.interfaces.IButton;
import org.openqa.selenium.By;

import static aquality.selenium.browser.AqualityServices.getElementFactory;

public class TestPageInfo {
    private final IButton ProjectName = getElementFactory().getButton(By.xpath("//div[contains(@class,'list-group-item')][1]//p"), "Project Name");
    private final ITextBox TestName = getElementFactory().getTextBox(By.xpath("//div[contains(@class,'list-group-item')][2]//p"), "Test Name");
    private final ITextBox TestMethod = getElementFactory().getTextBox(By.xpath("//div[contains(@class,'list-group-item')][3]//p"), "Test Method Name");
    private final ITextBox TestStatus = getElementFactory().getTextBox(By.xpath("//div[contains(@class,'list-group-item')][4]//p"), "Test Status");
    private final ITextBox Environment = getElementFactory().getTextBox(By.xpath("//div[contains(@class,'list-group-item')][6]//p"), "Environment Selected");
    private final ITextBox Browser = getElementFactory().getTextBox(By.xpath("//div[contains(@class,'list-group-item')][7]//p"), "Browser Selected");
    private final ITextBox StartTime = getElementFactory().getTextBox(By.xpath("//div[contains(@class,'list-group-item')][5]//p[1]"), "Start Time");
    private final ITextBox EndTime = getElementFactory().getTextBox(By.xpath("//div[contains(@class,'list-group-item')][5]//p[2]"), "End Time");
    public String getProjectName(){
        String project=ProjectName.getName();
        return project;
    }
    public String getTestName(){
        String testname=TestName.getName();
        return testname;
    }

    public String getTestMethod(){
        String testmethod=TestMethod.getName();
        return testmethod;
    }
    public String getTestStatus(){
        String testStatus=TestStatus.getName();
        return testStatus;
    }
    public String getEnvironment(){
        String environmentName=Environment.getName();
        return environmentName;
    }

    public String getBrowser(){
        String browsername=Browser.getName();
        return browsername;
    }
    public String getStartTime(){
        String starttime=StartTime.getName();
        return starttime;
    }
    public String getEndTime(){
        String endtime=EndTime.getName();
        return endtime;
    }
}
