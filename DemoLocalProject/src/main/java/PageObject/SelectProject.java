package PageObject;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import org.openqa.selenium.By;

import java.util.List;

import static aquality.selenium.browser.AqualityServices.*;

public class SelectProject {

    private final List<IButton> selectedProject = getElementFactory().findElements(By.xpath("//a[contains(@href,'allTests?projectId')]"), "Selected Project",ElementType.BUTTON);

    public void clickOnSelectedProject(int id){
        selectedProject.get(id).clickAndWait();
    }

    public List<ITextBox> testStartTime()  {
        List<ITextBox> testStartTime = getElementFactory().findElements(By.xpath("//table[contains(@class,'table')]//tr//td[4]"), "Latest Test Start Time", ElementType.TEXTBOX);
        return testStartTime;
    }
}
