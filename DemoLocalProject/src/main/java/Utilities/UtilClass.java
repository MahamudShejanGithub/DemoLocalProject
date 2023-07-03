package Utilities;
import DataReader.JSONFileReader;
import PageObject.SelectProject;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UtilClass {
    private final Browser browser = AqualityServices.getBrowser();
    private final SelectProject selectProject = new SelectProject();
    private static final String destination=".\\TestData\\screenshot.png";
   public void takeAndSaveScreenshots() {
       File screenshotFile = ((TakesScreenshot) browser).getScreenshotAs(OutputType.FILE);
       try {
           FileUtils.copyFile(screenshotFile, new File(destination));
       } catch (
               IOException e) {
           e.printStackTrace();
       }
   }

   public boolean checkSortedDateTime(){
           for (int i = 0; i < selectProject.testStartTime().size(); i++) {
            LocalDateTime time1 = null;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            time1 = LocalDateTime.parse(selectProject.testStartTime().get(i).toString(),formatter);
            LocalDateTime time2 = null;
            time2 = LocalDateTime.parse(selectProject.testStartTime().get(i + 1).toString(),formatter);
            time1.isBefore(time2);
            return true;
        }
       return true;
   }
    public static void uploadScreenShot(String key,String fileName) {
        try{
            Robot robot= new Robot();
            StringSelection stringSelection = new StringSelection(JSONFileReader.getJSONKeyValue(key,fileName));
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            robot.setAutoDelay(2000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
