import DataReader.JSONFileReader;
import JsMethod.JsScripts;
import PageObject.CreatedProject;
import PageObject.HomePage;
import PageObject.SelectProject;
import PageObject.TestPageInfo;
import Utilities.Constants;
import Model.Model;
import Utilities.UtilClass;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTdTask extends BaseTest {
    private static final CreatedProject createdProject= new CreatedProject();
    private static final Model model =new Model();
    private static final HomePage homePage = new HomePage();
    private static final Browser browser = AqualityServices.getBrowser();
    JsScripts js= new JsScripts();
    private static final SelectProject select = new SelectProject();
    private static final UtilClass util=new UtilClass();
    private static final TestPageInfo testPageInfo=new TestPageInfo();

    @Test
    public void TaskTD() {
        select.clickOnSelectedProject(8);
        Assert.assertTrue(util.checkSortedDateTime(), "The dates are not in descending order");
        homePage.gotoHome();
        homePage.addProject();
        homePage.sendProjectName(JSONFileReader.getJSONKeyValue(Constants.ProjectName, Constants.fileName));
        homePage.saveProject();
        Assert.assertEquals(homePage.popUpText(), "Project " + JSONFileReader.getJSONKeyValue(Constants.ProjectName, Constants.fileName) + " saved", "The alert message about saving project appeared");
        js.closePopUp();
        Assert.assertFalse(homePage.addProjectPanelIsNotDisplayed(), "Even After CLosing PopUp the Add Proeject Panel Still Appeared ");
        browser.refresh();
        model.setTestName(JSONFileReader.getJSONKeyValue(Constants.TestName, Constants.fileName));
        model.setTestMethod(JSONFileReader.getJSONKeyValue(Constants.TestMethod, Constants.fileName));
        model.setStartTime(JSONFileReader.getJSONKeyValue(Constants.StartTime, Constants.fileName));
        model.setEndTime(JSONFileReader.getJSONKeyValue(Constants.EndTime, Constants.fileName));
        model.setEnvironment(JSONFileReader.getJSONKeyValue(Constants.Environment, Constants.fileName));
        createdProject.clickCreatedProject();
        createdProject.clickAddTest();
        createdProject.setTestName(model.getTestName());
        createdProject.scrollStatusInDropdown();
        createdProject.statusClick();
        createdProject.setTestMethod(model.getTestMethod());
        createdProject.setStartTime(model.getStartTime());
        createdProject.setEndTime(model.getEndTime());
        createdProject.setTestEnv(model.getEnvironment());
        createdProject.setBrowser(JSONFileReader.getJSONKeyValueFromResources(Constants.Browser, Constants.fileNameOne));
        util.takeAndSaveScreenshots();
        UtilClass.uploadScreenShot(Constants.imglocation,Constants.fileNameTwo);
        Assert.assertEquals(createdProject.getAlertText(),"Test "+JSONFileReader.getJSONKeyValue(Constants.TestName, Constants.fileName)+" saved","Test Name doesn't match");
        createdProject.setSaveTest();
        Assert.assertEquals(testPageInfo.getProjectName(), JSONFileReader.getJSONKeyValue(Constants.ProjectName, Constants.fileName), "Project Name Doesn't Match");
        Assert.assertEquals(testPageInfo.getTestName(), JSONFileReader.getJSONKeyValue(Constants.TestName, Constants.fileName), "Test Name Doesn't Match");
        Assert.assertEquals(testPageInfo.getTestMethod(), JSONFileReader.getJSONKeyValue(Constants.TestMethod, Constants.fileName), "Test Method Name Doesn't Match");
        Assert.assertEquals(testPageInfo.getTestStatus(), createdProject.statusClick(), "Test Status Doesn't Match");
        Assert.assertEquals(testPageInfo.getEnvironment(), JSONFileReader.getJSONKeyValue(Constants.Environment, Constants.fileName), "Environment Doesn't Match");
        Assert.assertEquals(testPageInfo.getBrowser(), JSONFileReader.getJSONKeyValue(Constants.Browser, Constants.fileName), "Browser Doesn't Match");
        Assert.assertEquals(testPageInfo.getStartTime(), JSONFileReader.getJSONKeyValue(Constants.StartTime, Constants.fileName), "Start Time Doesn't Match");
        Assert.assertEquals(testPageInfo.getEndTime(), JSONFileReader.getJSONKeyValue(Constants.EndTime, Constants.fileName), "End Time Doesn't Match");
    }
}
