package PageObject;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import org.openqa.selenium.By;

import static aquality.selenium.browser.AqualityServices.getElementFactory;

public class HomePage {
    Browser browser = AqualityServices.getBrowser();
    private final IButton Home = getElementFactory().getButton(By.xpath("//a[contains(@href,'/web/projects')]"), "Home");
    private final IButton Add = getElementFactory().getButton(By.xpath("//button[contains(@data-target,'#addProject')]"), "Add");
    private final ITextBox ProjectName = getElementFactory().getTextBox(By.xpath("//input[contains(@type,'text')]"), "Enter Project Name");
    private final IButton SaveProject = getElementFactory().getButton(By.xpath("//button[contains(@type,'submit')]"), "Save Project");
    private final ITextBox alertMsg = getElementFactory().getTextBox(By.xpath("//div[contains(@class,'alert alert-success')]"), "Alert message about successFul saving appeared");
    private final ITextBox addProjectPanel = getElementFactory().getTextBox(By.xpath("//div[contains(@class,'modal-content')]"), "Add Project Panel");
    public  void gotoHome(){
        Home.clickAndWait();
    }
    public  void addProject(){
        Add.click();
    }
    public void sendProjectName(String projectName){
        ProjectName.type(projectName);
    }
    public String popUpText(){
       String popUpText= alertMsg.getText();
       return popUpText;
    }
    public void saveProject(){
        SaveProject.click();
    }
    public boolean addProjectPanelIsNotDisplayed(){
        if(addProjectPanel.state().isDisplayed()) {
            return true;
        }
        else
            return false;
    }
}
